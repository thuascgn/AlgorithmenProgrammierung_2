package shapes;
/**
 * Rectangle ist eine konkrete Shape-Klasse.
 * @author E. Ehses, FH Koeln
 */
public final class Rectangle extends AbstractShape {
    private double length, width;

    /**
     * Konstruktor.
     * 
     * @param name  Name des Rechteckobjekts.
     * @param length Laenge des Rechtecks.
     * @param width Breite des Rechtecks.
     */
    public Rectangle(String name, double length, double width) {
    	super(name);
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return "Rectangle."+getName();
    }
}
