package search.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import search.graph.Graph;
import search.graph.IObserver;
import search.graph.Node;
import search.graph.ObservableSolver;
import search.graph.Path;
import search.graph.SearchStrategy;
import search.gui.util.ErrorDialog;
import search.gui.util.LabelledItemPanel;
import search.gui.util.RadioButtonPanel;

/**
 * Die Klasse <code>DataPanel</code> verwaltet den Benutzerdialog.
 * Von hier aus wird die Graphsuche gestartet. Das Objekt registriert
 * sich als Beobachter der Suche und stellt die aktuelle Weglaenge dar.
 * 
 * @author Erich Ehses.
 */
@SuppressWarnings({"serial","rawtypes","unchecked"})
public final class DataPanel extends JPanel implements IObserver {    
    /*
     * Konstanten fuer das Aussehen der Graphik.
     */
    private static final Color BUTTON_COLOR = Color.darkGray;
    private static final Color START_COLOR = Color.green;
    private static final Color STOP_COLOR = Color.red;

    /*
     * Modelldaten.
     */
    private Graph graph; // der Graph, in dem gesucht wird
    private ObservableSolver solver; // der Problemloeser

    /*
     * Zahlenformate.
     */
    private DecimalFormat lengthFormat = new DecimalFormat("0.0 km");
    private DecimalFormat timeFormat = new DecimalFormat("0.000 s");
    private DecimalFormat countFormat = new DecimalFormat("0");

    /*
     * Rechenzeit.
     */
    private double startTime;
    
    /*
     * Widgets.
     */
    private LabelledItemPanel items;
    private JComboBox startSelection;
    private JComboBox goalSelection;
    private JTextField pathField;
    private JTextField countField;
    private JTextField visitedNodesField;
    private JTextField timeField;
    private JTextArea pathArea;
    private RadioButtonPanel algoSelection;
    private JSlider delaySlider;
    private JButton startButton;

    /**
     * Die Namen der Algorithmen.
     */
    private static final String[] algoNames =
        { "Zufallssuche", "Tiefensuche", "Breitensuche", "Dijkstra",
          "Bergsteigen", "A*" };

    /**
     * Die Tags der Algorithmen.
     */
    private static final SearchStrategy[] algorithms =
        {
            SearchStrategy.RANDOM,
            SearchStrategy.LIFO,
            SearchStrategy.FIFO,
            SearchStrategy.PATH_LENGTH,
            SearchStrategy.HILL_CLIMBING,
            SearchStrategy.A_STAR };

    /**
     * Konstruktor. Erzeugt ein fertiges Eingabepanel.
     * Wenn <code>printTree = true</code> erfolgt eine Konsolausgabe des
     * Suchbaums.
     * 
     * @param solver das suchende Objekt.
     * @param graph der Graph in dem gesucht wird.
     * @param printTree true, wenn Konsolausgabe.
     */
    public DataPanel(ObservableSolver solver, Graph graph) {
        this.solver = solver;
        this.graph = graph;

        setLayout(new BorderLayout());
        setBorder(new BevelBorder(BevelBorder.RAISED));

        initLabelledItemPanel();
        add(items, BorderLayout.NORTH);

        startButton = new JButton();
        setButtonToStart();
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startOrStopApplication();
            }
        });
        add(startButton, BorderLayout.SOUTH);
    }

    /**
     * Initialisiert die Komponenten des Unterfensters
     * fuer die Eingabe.
     */
    private void initLabelledItemPanel() {
        items = new LabelledItemPanel();
        String[] nodeNames = graph.nodeNames();

        startSelection = new JComboBox(nodeNames);
        items.addItem("Startpunkt", startSelection);
        goalSelection = new JComboBox(nodeNames);
        items.addItem("Zielpunkt", goalSelection);
        pathField = createTextField();
        items.addItem("Weglaenge", pathField);
        countField = createTextField();
        items.addItem("Anzahl Orte", countField);
        visitedNodesField = createTextField();
        items.addItem("besuchte Orte", visitedNodesField);
        timeField = createTextField();
        items.addItem("Laufzeit", timeField);
        pathArea = new JTextArea(8, 0);
        pathArea.setEditable(false);
        JScrollPane pane = new JScrollPane(pathArea);
        pane.setBorder(new BevelBorder(BevelBorder.LOWERED));
        items.addItem("Weg", pane);
        algoSelection = new RadioButtonPanel(algoNames);
        items.addItem("Algorithmus", algoSelection);
        delaySlider = createSlider();
        items.addItem("Verz�gerung", delaySlider);
    }

    /**
     * Erzeugt ein mit - initialisiertes Textfeld. Texte sind rechts ausgerichtet
     * und nicht veraenderbar.
     * 
     * @return erzeugtes Textfielld-Objekt.
     */
    private JTextField createTextField() {
        JTextField field = new JTextField("-");
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setEditable(false);
        return field;
    }

    /**
     * Erzeugt einen Slider zur Einstellung der Animationsgeschwindigkeit.
     * Der Bereich der einstellbaren Zeitverzoegerung liegt zwischen 0
     * und 4 Sekunden (Default = 2).
     * @return Slider-Objekt.
     */
    private JSlider createSlider() {
        final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 7, 4);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (!slider.getValueIsAdjusting()) {
                    setDelayTime();
                }
            }
        });
        return slider;
    }

    /**
     * Die fest eingestellten Stufen der Verzoegerungszeit.
     * (alle Werte sind in Millisekunden)
     */
    private static final long[] DELAY_TIMES =
        { 0, 1, 100, 200, 400, 700, 1500, 3000 };

    /**
     * Uebermittelt die in delaySlider eingestellte
     * Verzoegerungszeit an den Loesungsalgorithmus
     */
    private void setDelayTime() {
        long delay = DELAY_TIMES[(int)delaySlider.getValue()];
        solver.setDelay(delay);
    }

    /**
     * Startet/stoppt die Suche.
     * Das Verhalten entspricht einem "Toggle".
     * Beim Start werden die Werte des Panels uebernommen.
     * Da die Suche in einem eigenen Thread laeuft, kehrt die
     * Methode sofort zurueck.
     */
    private void startOrStopApplication() {
        if (!solver.isStopped()) { // stop it.
            setButtonToStart();
            solver.stopSearch();
        } else {                  // let's go.
            setButtonToStop();
            String startName = startSelection.getSelectedItem().toString();
            String goalName = goalSelection.getSelectedItem().toString();
            int index = algoSelection.getSelectedIndex();
            setDelayTime();
            try {
                solver.start(algorithms[index], graph.findNode(startName),
                    graph.findNode(goalName));
            } catch (UnsupportedOperationException e) {
                setButtonToStart();
                new ErrorDialog(algoNames[index] + " ist nicht implementiert");
            }
        }
    }

    public void update(Path path) {
        pathField.setText(lengthFormat.format(path.pathLength()));
        countField.setText(countFormat.format(path.size()));
        visitedNodesField.setText(
                countFormat.format(solver.numberOfVisitedNodes()));
        displayElapsedTime();
        if (solver.isStopped()) {
            final List<Node> trace = path.nodes();
            final LinkedList<String> pathList = new LinkedList<String>();
            for (Node n: trace) pathList.addFirst(n.toString());
            // Aenderungen der GUI
            // sollten nur im Event-Thread erfolgen !
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    showPath(pathList);
                    setButtonToStart();
                }
            });
        }
    }
    
    /**
     * Gibt die Liste der Knotennamen aus.
     * 
     * @param pathList Stringliste der Knotennamen.
     */
    private void showPath(final List<String> pathList) {
        pathArea.setText(null);
        if (pathList == null) return;
        for (String name : pathList)
            pathArea.append(name+"\n");
    }
    
    /**
     * Startet die Zeitmessung.
     */
    private void startTimer() {
        startTime = System.currentTimeMillis();
    }
    
    /**
     * Gibt aus wie lange die Suche (bereits) dauert.
     */
    private void displayElapsedTime() {
        double totalTime = 1E-3 * (System.currentTimeMillis() - startTime);
        timeField.setText(timeFormat.format(totalTime));
    }


    /**
     * Definiert das Aussehen des Startknopfes.
     */
    private void setButtonToStart() {
        startButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        startButton.setBackground(BUTTON_COLOR);
        startButton.setForeground(START_COLOR);
        startButton.setText("start");
    }
    
    /**
     * Definiert das Aussehen des Stopknopfes.
     */
    private void setButtonToStop() {
        startButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        startButton.setBackground(BUTTON_COLOR);
        startButton.setForeground(STOP_COLOR);
        startButton.setText("stop");
        startTimer();
    }
}
