package shapes;
import java.util.LinkedList;
import java.util.List;

/**
 * Einfache Menuestruktur.
 * Die Klasse erlaubt die Definition eines Menues und die Auswahl und
 * Ausfuehrung der Menueaktion.
 * 
 * @author E. Ehses, FH Koeln
 */
public class Menu {
    /**
     * Geschachtelte Klasse zum Speichern einer Menueaktion.
     */
    private static class Item {
        /**
         * Auswahlbuchestabe
         */
        char key;
        /**
         * Text der Menuezeile.
         */
        String name;
        /**
         * Objekt fuer die Ausfuehrung der gewaehlten
         * Aktion. Wenn <tt>action == null</tt> ist, wird
         * anstelle der Aktion die Methode <tt>runloop</tt>
         * beendet.
         */
        Command action;

        /**
         * Speichert eine Menuezeile zusammen mit der auszuloesenden Aktion.
         * 
         * @param name lesbarer Name der Menuezeile
         * @param action auszufuehrende Aktion
         */
        Item(char key, String name, Command action) {
            this.key = key;
            this.name = name;
            this.action = action;
        }
        
        @Override
        public String toString() {
            return key + ": " + name;
        }
    }

    private String title;
    private boolean allDone;
    private List<Item> menu = new LinkedList<Item>();

    /**
     * Erzeugt ein neues Menue.
     * 
     * @param title Titelzeile
     */
    public Menu(String title) {
        this.title = title;
    }

    /**
     * Definiert eine (weitere) Menuezeile. Wenn das <code>action</code>
     * gleich <code>null</code> ist wird bei Auswahl dieses
     * Punktes anstelle einer Aktion die Menue-Schleife beendet.
     * 
     * @param name Beschreibung der Auswahl
     * @param key Kuerzel fuer die Auswahl (ein Buchstabe!)
     * @param action Aktionsobjekt
     */
    public void add(String name, char key, Command action) {
        if (action == null) 
            action = new Command() {
                public void execute() { allDone = true;}
            };
        menu.add(new Item(Character.toLowerCase(key), name, action));
    }

    /**
     * Stellt ein Menue dar und fuehrt die gewaehlten Aktionen aus.
     * Zunaechst wird der Menuetext auf den Bildschirm geschrieben.
     * Anschliessend wird auf eine mit Return abgeschlossene Zeile gewartet, die
     * genau ein Zeichen enthaelt. Wenn definiert, wird die zu diesem Zeichen
     * gehoerende Aktion ausgefuehrt (Ansonsten wird nachgefragt). Wenn
     * keine andere Aktion fuer den gewaehlten Item definiert ist,
     * wird die Menueabfrage beendet. Anderfalls wird erneut abgefragt.
     */
    public void runloop() {
        while (!allDone) {
            printList();
            String input = Console.readLine(": ");
            if (input.length() != 1)
                System.out.println("1 Buchstabe bitte!");
            else {
                Item item = findMenuItem(input);
                if (item == null) 
                    System.out.println("illegaler Buchstabe");
                else
                    item.action.execute();
            }
        }
    }

    /**
     * Sucht die gewaehlten Menuezeile.
     * @param input Eingabezeichen
     * @return gefundener Item oder <tt>null</tt>.
     */
    private Item findMenuItem(String input) {
        Character selection = Character.toLowerCase(input.charAt(0));
        for (Item item : menu) {
            if (item.key == selection) return item;
        }
        return null;
    }

    /**
     * Gibt die Menuepunkte aus.
     */
    private void printList() {
        System.out.println();
        System.out.println(title);
        for (Item item : menu) 
            System.out.println(item);
    }

}