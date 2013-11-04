package shapes;
/**
 * Rectangle ist eine konkrete Shape-Klasse.
 * @author E. Ehses, FH Koeln
 */
public final class Circle extends AbstractShape {
    private double radius;

    /**
     * Konstruktor.
     * 
     * @param name  Name des Rechteckobjekts.
     * @param length Laenge des Rechtecks.
     * @param width Breite des Rechtecks.
     */
    public Circle(String name, double radius) {
    	super(name);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "Circle."+getName();
    }
}
