package shapes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Steuert die Anwendung
 * 
 * @author E. Ehses, FH Koeln
 */
public class Application {
    private List<IShape> liste = new ArrayList<IShape>();

	class Klasse implements Command{
		public void execute() {
			String name = Console.readLine("Name:");
			double laenge = Console.readDouble("Laenge:");
			double breite = Console.readDouble("Breite:");
			liste.add(new Rectangle(name, laenge, breite));
		}
	}
    
    /**
     * Erzeugt das Menue fuer die Befehlsauswahl. Dem Menue werden
     * (anonyme) Objekte mitgeteilt, die eine Callback-Funktion fuer
     * die Befehlsausfuehrung beeinhalten.
     * <p>
     * Mit den Befehlen kann man eine Liste von Shape-Objekten erzeugen
     * und ihre Eigenschaften abfragen.
     */
    public void start() {
        Menu menu = new Menu("Auswahl der Aktion");
        menu.add("Rechteck erzeugen", 'r', new Klasse());
//        menu.add("Rechteck erzeugen", 'r', new Command() {
//            public void execute() {
//                String name = Console.readLine("Name:");
//                double laenge = Console.readDouble("Laenge:");
//                double breite = Console.readDouble("Breite:");
//                liste.add(new Rectangle(name, laenge, breite));           
//            }
//        });
        menu.add("Kreis erzeugen", 'k', new Command() {
            public void execute() {
                String name = Console.readLine("Name:");
                double radius = Console.readDouble("Radius:");
                liste.add(new Circle(name, radius));
            }
        });
        menu.add("nach Flaeche sortiert ausgeben", 'f', new Command() {
            public void execute() {
                Collections.sort(liste);
                printList("nach Flaeche sortiert: ");
            }
        });
        menu.add("nach Name sortiert ausgeben", 'n', new Command() {
            public void execute() {
                Collections.sort(liste, new ShapesAlphabetisch());
                printList("nach Name sortiert: ");
            }
        });
        menu.add("nach Fläche sortiert ausgeben / Kataster", 'd', new Command() {
        	public void execute(){
        		Collections.sort(liste, new ShapesKataster());
        		printList("Kataster sort: ");
        	}
        });
        menu.add("Gesamtflaeche ausgeben", 'g', new Command() {
            public void execute() {
                double summe = 0.0;
                for (IShape f : liste) summe += f.getArea();  
                System.out.printf("Gesamte Flaeche: %.2f%n", summe);
            }
        });
        menu.add("Ende", 'e', null);
        menu.runloop();             
    }

    /**
     * Gibt alle Daten eines IShape-Feldes aus.
     * 
     * @param title Ueberschrift ï¿½ber die Ausgabe.
     */
    private void printList(String title) {
        System.out.println("\n" + title);
        for (IShape s : liste)
            System.out.printf("    %s, Flaeche: %.2f%n", s, s.getArea());
    }
}
