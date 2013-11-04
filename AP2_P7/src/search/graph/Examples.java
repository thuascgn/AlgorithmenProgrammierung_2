package search.graph;

/**
 * Zwei Beispielgraphen.
 *
 */
public final class Examples {

    private Examples() {
    }
    
    /**
     * Erzeugt einen Graphen fuer einige deutsche Staedte und ihre
     * Strassenverbindungen.
     * 
     * @return Graph fuer das Verkehrsnetz.
     */
    public static Graph germany() {
        /*
         * Die Argumente zu addNode beziehen sich auf Breite und Laenge der
         * Orte (ungefaehr).
         */
        Graph g = new Graph();
        addNode(g, "Flensburg",54.75,9.5);
        addNode(g, "Kiel",54.3,10.2);
        addNode(g, "L�beck",53.9,10.75);
        addNode(g, "Hamburg",53.6,10);
        addNode(g, "Bremen",53.1,8.8);
        addNode(g, "Bremerhaven",53.6,8.6);
        addNode(g, "Wilhelmshaven",53.6,8.1);
        addNode(g, "Oldenburg",53.2,8.2);
        addNode(g, "Osnabr�ck",52.3,8.1);
        addNode(g, "Hannover",52.4,9.7);
        addNode(g, "Braunschweig",52.3,10.5);
        addNode(g, "G�ttingen",51.5,9.9);
        addNode(g, "Kassel",51.3,9.5);
        addNode(g, "Bielefeld",52,8.5);
        addNode(g, "M�nster",51.9,7.6);
        addNode(g, "Duisburg",51.4,6.7);
        addNode(g, "Essen",51.4,7.1);
        addNode(g, "Dortmund",51.5,7.5);
        addNode(g, "Wuppertal",51.3,7.2);
        addNode(g, "D�sseldorf",51.2,6.8);
        addNode(g, "M�nchengladbach",51.3,6.4);
        addNode(g, "K�ln",50.9,6.9);
        addNode(g, "Bonn",50.7,7.1);
        addNode(g, "Koblenz",50.4,7.6);
        addNode(g, "Aachen",50.8,6.1);
        addNode(g, "Trier",49.75,6.6);
        addNode(g, "Saarbr�cken",49.2,7);
        addNode(g, "Wiesbaden",50.1,8.2);
        addNode(g, "Mainz",50,8.2);
        addNode(g, "Kaiserslautern",49.4,7.75);
        addNode(g, "Mannheim",49.5,8.5);
        addNode(g, "Heidelberg",49.4,8.7);
        addNode(g, "Karlsruhe",49,8.4);
        addNode(g, "Pforzheim",48.9,8.7);
        addNode(g, "Stuttgart",48.8,9.2);
        addNode(g, "Freiburg",48,7.8);
        addNode(g, "L�rrach",47.6,7.6);
        addNode(g, "Villach",48,8.5);
        addNode(g, "Singen",47.75,8.8);
        addNode(g, "Lindau",47.5,9.7);
        addNode(g, "Ulm",48.4,10);
        addNode(g, "Kempten",47.7,10.3);
        addNode(g, "Augsburg",48.4,10.8);
        addNode(g, "M�nchen",48.2,11.6);
        addNode(g, "Passau",48.6,13.5);
        addNode(g, "Regensburg",49,12.1);
        addNode(g, "N�rnberg",49.4,11.1);
        addNode(g, "Erlangen",49.6,11);
        addNode(g, "Bayreuth",49.9,11.6);
        addNode(g, "Bamberg",49.9,10.9);
        addNode(g, "W�rzburg",49.8,9.9);
        addNode(g, "Heilbronn",49.2,9.2);
        addNode(g, "Darmstadt",49.8,8.6);
        addNode(g, "Frankfurt",50.1,8.6);
        addNode(g, "Schweinfurt",50,10.2);
        addNode(g, "Siegen",50.9,8);
        addNode(g, "Giessen",50.6,8.7);
        addNode(g, "Paderborn",51.2,8.7);
        addNode(g, "Rosenheim",47.8,12.2);
        addNode(g, "T�bingen",48.5,9.1);
        addNode(g, "Ingolstadt",48.75,11.4);
        addNode(g, "Berlin",52.5,13.5);
        addNode(g, "Frankfurt/Oder",52.3,14.5);
        addNode(g, "Cottbus",51.75,14.3);
        addNode(g, "Chemnitz",50.8,12.9);
        addNode(g, "Brandenburg",52.4,12.5);
        addNode(g, "Magdeburg",52.1,11.6);
        addNode(g, "Halle",51.5,12);
        addNode(g, "Erfurt",51,11);
        addNode(g, "Gera",50.8,12.1);
        addNode(g, "Leipzig",51.3,12.4);
        addNode(g, "Dresden",51.1,13.75);
        addNode(g, "G�rlitz",51.2,15);
        addNode(g, "Schwerin",53.6,11.4);
        addNode(g, "Rostock",54.1,12.1);
        addNode(g, "Stralsund",54.3,13.1);
        addNode(g, "Greifswald",54.1,13.4);
        addNode(g, "Neubrandenburg",53.6,13.25);
        g.addEdge("Flensburg","Kiel");
        g.addEdge("Kiel","L�beck");
        g.addEdge("Kiel","Hamburg");
        g.addEdge("L�beck","Hamburg");
        g.addEdge("Hamburg","Bremen");
        g.addEdge("Hamburg","Bremerhaven");
        g.addEdge("Hamburg","Hannover");
        g.addEdge("Hamburg","Braunschweig");
        g.addEdge("Bremen","Bremerhaven");
        g.addEdge("Bremen","Oldenburg");
        g.addEdge("Bremen","Hannover");
        g.addEdge("Bremen","Osnabr�ck");
        g.addEdge("Oldenburg","Wilhelmshaven");
        g.addEdge("Oldenburg","Osnabr�ck");
        g.addEdge("Hannover","Osnabr�ck");
        g.addEdge("Hannover","Braunschweig");
        g.addEdge("Hannover","G�ttingen");
        g.addEdge("Hannover","Paderborn");
        g.addEdge("Hannover","Bielefeld");
        g.addEdge("Braunschweig","G�ttingen");
        g.addEdge("G�ttingen","Kassel");
        g.addEdge("Osnabr�ck","Bielefeld");
        g.addEdge("Osnabr�ck","M�nster");
        g.addEdge("Bielefeld","Paderborn");
        g.addEdge("Bielefeld","Dortmund");
        g.addEdge("M�nster","Dortmund");
        g.addEdge("M�nster","Essen");
        g.addEdge("Paderborn","Kassel");
        g.addEdge("Paderborn","Dortmund");
        g.addEdge("Dortmund","Wuppertal");
        g.addEdge("Dortmund","Siegen");
        g.addEdge("Essen","Duisburg");
        g.addEdge("Duisburg","D�sseldorf");
        g.addEdge("Duisburg","M�nchengladbach");
        g.addEdge("D�sseldorf","M�nchengladbach");
        g.addEdge("D�sseldorf","K�ln");
        g.addEdge("D�sseldorf","Wuppertal");
        g.addEdge("M�nchengladbach","Aachen");
        g.addEdge("M�nchengladbach","K�ln");
        g.addEdge("Aachen","K�ln");
        g.addEdge("Wuppertal","Essen");
        g.addEdge("Wuppertal","K�ln");
        g.addEdge("Kassel","Giessen");
        g.addEdge("Siegen","Giessen");
        g.addEdge("Giessen","Frankfurt");
        g.addEdge("Giessen","Koblenz");
        g.addEdge("K�ln","Trier");
        g.addEdge("K�ln","Bonn");
        g.addEdge("Bonn","Koblenz");
        g.addEdge("Koblenz","Trier");
        g.addEdge("Koblenz","Mainz");
        g.addEdge("Trier","Saarbr�cken");
        g.addEdge("Trier","Kaiserslautern");
        g.addEdge("Trier","Mainz");
        g.addEdge("Saarbr�cken","Kaiserslautern");
        g.addEdge("Saarbr�cken","Karlsruhe");
        g.addEdge("Kaiserslautern","Mannheim");
        g.addEdge("Mainz","Wiesbaden");
        g.addEdge("Mainz","Mannheim");
        g.addEdge("Wiesbaden","Frankfurt");
        g.addEdge("Wiesbaden","Darmstadt");
        g.addEdge("Frankfurt","Darmstadt");
        g.addEdge("Frankfurt","W�rzburg");
        g.addEdge("Darmstadt","Mannheim");
        g.addEdge("Mannheim","Heidelberg");
        g.addEdge("Heidelberg","Karlsruhe");
        g.addEdge("Heidelberg","Heilbronn");
        g.addEdge("W�rzburg","Heilbronn");
        g.addEdge("W�rzburg","Erlangen");
        g.addEdge("W�rzburg","Schweinfurt");
        g.addEdge("W�rzburg","Bamberg");
        g.addEdge("Bamberg","Bayreuth");
        g.addEdge("Bamberg","Erlangen");
        g.addEdge("Bayreuth","Erlangen");
        g.addEdge("Heilbronn","N�rnberg");
        g.addEdge("Heilbronn","Stuttgart");
        g.addEdge("Karlsruhe","Pforzheim");
        g.addEdge("Karlsruhe","Freiburg");
        g.addEdge("Pforzheim","Stuttgart");
        g.addEdge("Stuttgart","T�bingen");
        g.addEdge("Stuttgart","Ulm");
        g.addEdge("T�bingen","Villach");
        g.addEdge("Freiburg","L�rrach");
        g.addEdge("Freiburg","Villach");
        g.addEdge("L�rrach","Singen");
        g.addEdge("Singen","Villach");
        g.addEdge("Singen","Lindau");
        g.addEdge("Lindau","Kempten");
        g.addEdge("Lindau","Ulm");
        g.addEdge("Ulm","Augsburg");
        g.addEdge("Augsburg","N�rnberg");
        g.addEdge("Augsburg","M�nchen");
        g.addEdge("N�rnberg","Erlangen");
        g.addEdge("N�rnberg","Ingolstadt");
        g.addEdge("N�rnberg","Regensburg");
        g.addEdge("Ingolstadt","Regensburg");
        g.addEdge("Ingolstadt","M�nchen");
        g.addEdge("Regensburg","Passau");
        g.addEdge("M�nchen","Passau");
        g.addEdge("M�nchen","Rosenheim");
        g.addEdge("M�nchen","Kempten");
        g.addEdge("Kempten","Ulm");
        g.addEdge("Kempten","Augsburg");
        g.addEdge("Dortmund","Essen");
        g.addEdge("Berlin","Brandenburg");
        g.addEdge("Berlin","Frankfurt/Oder");
        g.addEdge("Berlin","Halle");
        g.addEdge("Berlin","Cottbus");
        g.addEdge("Berlin","Dresden");
        g.addEdge("Berlin","Schwerin");
        g.addEdge("Berlin","Rostock");
        g.addEdge("Berlin","Neubrandenburg");
        g.addEdge("Schwerin","Hamburg");
        g.addEdge("Schwerin","L�beck");
        g.addEdge("Schwerin","Rostock");
        g.addEdge("Rostock","Stralsund");
        g.addEdge("Stralsund","Greifswald");
        g.addEdge("Neubrandenburg","Greifswald");
        g.addEdge("Frankfurt/Oder","Cottbus");
        g.addEdge("Dresden","Cottbus");
        g.addEdge("Dresden","Chemnitz");
        g.addEdge("Dresden","G�rlitz");
        g.addEdge("Dresden","Leipzig");
        g.addEdge("G�rlitz","Cottbus");
        g.addEdge("Chemnitz","Leipzig");
        g.addEdge("Chemnitz","Gera");
        g.addEdge("Gera","Leipzig");
        g.addEdge("Gera","Erfurt");
        g.addEdge("Leipzig","Halle");
        g.addEdge("Halle","Magdeburg");
        g.addEdge("Brandenburg","Magdeburg");
        g.addEdge("Erfurt","Kassel");
        g.addEdge("Chemnitz","Bayreuth");
        g.addEdge("Magdeburg","Braunschweig");
        g.addEdge("Erfurt","Halle");
        g.addEdge("Erfurt","Giessen");
        g.addEdge("Erfurt","Schweinfurt");        
        return g;
    }
    
    /**
     * Erzeugt einen ganz einfachen Testgraphen.
     * @return Testgraph.
     */
    public static Graph test() {
        Graph g = new Graph();
        g.addNode("A", 0,0);
        g.addNode("B", 1,0);
        g.addNode("C", 1,1);
        g.addNode("D", 0,1);
        g.addNode("E", 0.5, 0.5);
        g.addNode("F", 1, 0.9);
        g.addEdge("A", "B");
        g.addEdge("B", "F");
        g.addEdge("F", "C");
        g.addEdge("C", "D");
        g.addEdge("D", "A");
        g.addEdge("E", "F");
        g.addEdge("A", "E");
        return g;
    }
    
    /**
     * Wandle die geographische Information in ein Kilometernetz um
     * und trage den Knoten im Graphen ein.
     * Diese Methode funktioniert nur fuer Deutschland.
     * @param g Graph in den der Knoten eingetragen wird.
     * @param name Knotenname.
     * @param latitude geographische Breite des Ortes.
     * @param longitude geographische Laenge des Ortes.
     */
    private static void addNode(Graph g, String name, 
        double latitude, double longitude)
    {
        g.addNode(name, longitude*71.0, latitude*111.0);    
    }
    
}
