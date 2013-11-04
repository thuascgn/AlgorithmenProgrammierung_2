package search.gui;

import java.util.Iterator;

import search.graph.Graph;
import search.graph.Node;

/**
 * Die Klasse Scales hat die Aufgabe die Weltkoordinaten des Graphs in
 * Bildschirmkoordinaten umzurechnen.
 * 
 * @author Erich Ehses
 *  
 */
class Scales {

    private double sX;
    private double sY;
    private double offX;
    private double offY;
    private static final int INSET = 25;
    private int _width;
    private int _height;

    /**
     * Konstruktor.
     * 
     * @param g Graphdatenstruktur der Straßenkarte
     * @param width Fensterbreite in Pixeleinheiten.
     * @param height Fensterhöhe in Pixeleinheiten.
     */
    Scales(Graph g, int width, int height) {
        this._width = width;
        this._height = height;
        findScale(g);
    }

    /**
     * Bestimmt die Skalierungparameter. Diese Methode wird nur einmalig durch
     * den Konstruktor aufgerufen.
     * 
     * @param graph Datenstruktur des Graphen.
     */
    private void findScale(Graph graph) {
        Iterator<Node> iter = graph.nodes().iterator();
        Node first = iter.next();
        double minX = first.getX();
        double maxX = minX;
        double minY = first.getY();
        double maxY = minY;
        while (iter.hasNext()) {
            Node node = iter.next();
            double x = node.getX();
            double y = node.getY();
            minX = Math.min(x, minX);
            maxX = Math.max(x, maxX);
            minY = Math.min(y, minY);
            maxY = Math.max(y, maxY);
        }
        double dx = (maxX - minX);
        double dy = (minY - maxY);
        int w = _width - 2 * INSET;
        int h = _height - 2 * INSET;
        sX = w / dx;
        sY = h / dy;
        offX = -w * minX / dx + INSET;
        offY = -h * maxY / dy + INSET;
    }

    /**
     * Gibt die Hoehe des Fensters zurueck.
     * 
     * @return Höhe.
     */
    int getHeight() {
        return _height;
    }

    /**
     * Gibt die Breite des Fensters zurueck.
     * 
     * @return Breite.
     */
    int getWidth() {
        return _width;
    }

    /**
     * Transformiert x-Koordinaten auf den Bildschirm.
     * 
     * @param node Knoten.
     * @return Pixelindex in x-Richtung.
     */
    int getX(Node node) {
        return (int) (sX * node.getX() + offX);
    }

    /**
     * Transformiert y-Koordinaten auf den Bildschirm.
     * 
     * @param node Knoten.
     * @return Pixelindex in y-Richtung.
     */
    int getY(Node node) {
        return (int) (sY * node.getY() + offY);
    }
}