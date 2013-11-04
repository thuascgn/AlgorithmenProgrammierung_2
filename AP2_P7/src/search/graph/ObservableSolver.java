package search.graph;

import java.util.HashSet;
import java.util.Set;

import search.util.IQueue;

/**
 * Die Klasse vereint einen Graphsuche-Algorithmus und die noetigen Methoden um
 * seinen Ablauf zu beobachten.
 * <p>
 * Die Beobachtung wird durch Verwendung des Beobachter-Musters gemaess
 * {@link java.util.Observable}und {@link java.util.Observer}unterstuetzt.
 * <p>
 * Das Loesungsverhalten des Algorithmus haengt entscheident von der von der
 * Suchstrategie bereitgestellten Datenstruktur ({@link search.util.IQueue})
 * ab. Sofern, diese keine Elemente "vergisst" oder "verdoppelt", kann aber
 * garantiert werden, dass bei einem endlichen Graphen eine Loesung gefunden
 * wird, sofern sie existiert oder dass anderfalls in endlicher Zeit die
 * Nichtexistenz einer Loesung festgestellt wird. Bei unendlichen Graphen sind
 * keine allgemeinen Aussagen moeglich. Die Art und Qualitaet der Loesung haengt
 * ausschliesslich von dem Verhalten des Verfahrens ab.
 * <p>
 * Da in der Regel der Algorithmus nebenlaeufig ausgefuehrt wird, ist er als eine
 * <code>run</code> -Methode realisiert. Die Klasse ist insofern threadsicher
 * als sie (bei Verzoegerungszeit ungleich 0) jederzeit unterbrochen werden kann,
 * und insofern als die Verzoegerungszeit jederzeit veraendert werden kann. Die
 * Abfrage der Daten der Suche liefert stets den aktuellen Wert. Die Suche wird
 * nicht mit den Beobachtern synchronisiert.
 * <p>
 * Die Unterbrechung per <code>Thread.interrupt()</code> ist nicht vorgesehen
 * und wird als fataler Fehler (<code>Error</code>) behandelt.
 * 
 * @author Erich Ehses.
 * 
 * @see java.util.Observer
 * @see java.util.Observable
 * @see java.lang.Runnable
 */
public final class ObservableSolver {

    private IQueue<Path> openQueue; // Liste der zu verfolgenden Pfade.
    private final Set<Node> closedSet
        = new HashSet<Node>(); // Menge der abgeschl. Orte.
    private Path path; // aktueller Pfad.
    private volatile boolean stopped = true; // Suche ist beendet oder angehalten.
    private volatile long delay = 1; // Zeitverzoegerung pro Schritt.
    private Set<IObserver> obs = new HashSet<IObserver>(); // Beobachter
    private static final boolean IS_STARTED = true;
    
    private volatile int numberOfVisitedNodes;

    /**
     * Legt die Suchparameter fest und veranlasst den Start der Suche.
     * Die Methode wartet, bis eine noch laufende Suche beendet wurde.
     * Sie kehrt dann sofort zurueck.
     * 
     * @param strategy bestimmt das Suchverfahren.
     * @param startNode Name des Startknotens.
     * @param goalNode Name des Zielknotens.
     */
    public synchronized void start(SearchStrategy strategy, Node startNode,
                                   Node goalNode) {
        waitWhile(IS_STARTED);
        openQueue = strategy.makeQueue();
        path = new Path(startNode, goalNode);
        stopped = false;
        numberOfVisitedNodes = 0;
        notifyAll();
    }
    
    /**
     * Anzahl der Orte, die bei der Suche betreten wurden.
     * @return Anzahl der besuchten Orte
     */
    public int numberOfVisitedNodes() {
        return numberOfVisitedNodes;
    }

    /**
     * Wartet solange die angegebene Bedingung gilt oder angehalten ist.
     * 
     * @param condition Bedingung, die zum Warten fuehrt.
     */
    private synchronized void waitWhile(boolean condition) {
        try {
            while (condition ^ stopped)
                wait();
        } catch (InterruptedException ignore) {
            // never happens
        }
    }

    /**
     * Veraendert die Verzoegerung pro Schritt. Bei dem Wert 0 findet kein Warten
     * statt und in diesem Fall erfolgt weder eine Verlaufsmeldung noch kann die
     * Suche abgebrochen werden.
     * 
     * @param delay Verzoegerung in Millisekunden.
     */
    public synchronized void setDelay(long delay) {
        if (delay < 0) delay = 0;
        this.delay = delay;
        notifyAll();
    }

    /**
     * Haelt die Suche an.
     */
    public synchronized void stopSearch() {
        stopped = true;
        notifyAll();
    }

    /**
     * Fragt ab, ob die Suche gerade ausgefuehrt wird.
     * 
     * @return <code>true</code>, wenn die Suche laeuft.
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * Endlosschleife zur Durchfuehrung von Suchauftraegen. Die Suche wird mit
     * <code>start</start> gestartet.
     * Dabei werden auch die Loesungsparameter definiert.
     * <p>
     * Wenn die Verzoegerungszeit groesser als 0 ist, werden
     * alle registrierten Beobachter von Veraenderungen informiert.
     * In diesem Fall kann auch die Suche abgebrochen werden.
     */
    public void runloop() {
        while (true) {
            waitWhile(!IS_STARTED);
            initializeSearch();
            while (!(isStopped() || openQueue.isEmpty())) {
                path = openQueue.get();
                if (path.isComplete()) {
                    numberOfVisitedNodes++;
                    break;
                }
                Node front = path.lastNode();
                if (!closedSet.contains(front)) {
                    numberOfVisitedNodes++;
                    closedSet.add(front);
                    addNeighbourNodes(front);
                }
            }
            stopSearch();
            fireModelChanged(path);
        }
    }

    /**
     * Traegt um die naechsten Nachbarn erweiterte Pfade in die Warteschlange ein.
     */
    private void addNeighbourNodes(Node front) {
        for (Node neighbour : front.neighbours()) {
            if (!closedSet.contains(neighbour)) {
                openQueue.put(path.add(neighbour));
            }
        }
        traceSingleStep();
    }
    
    /**
     * Fuehrt die Aktionen bei der verzoegerten Ausf�hrung eines
     * Suchschritts aus. Dazu gehoert die Ausfuehrung der Verzoegerung
     * und die Benachrichtigung aller registrierten Listener.
     */
    private void traceSingleStep() {
        long dly;
        synchronized (this) {
            dly = delay;
        }
        if (dly != 0) {
            fireModelChanged(path);
            synchronized (this) {
                try {
                    wait(dly);
                } catch (InterruptedException ignore) {
                    // never happens
                }
            }
        }
    }

    /**
     * Initialisiert die Datenstrukturen der Suche und benachrichtigt
     * alle registrierten Listener von dem neuen Ausgangszustand.
     */
    private void initializeSearch() {
        openQueue.clear();
        openQueue.put(path);
        closedSet.clear();
        fireModelChanged(path);
    }

    /**
     * Registriert einen Beobachter.
     * Beobachter werden bei jeder Erweiterung des Suchpfades informiert.
     * 
     * @param observer Beobachter.
     */
    public void addObserver(IObserver observer) {
        obs.add(observer);
    }

    private void fireModelChanged(Path p) {
        for (IObserver observer : obs)
            observer.update(p);
    }
}