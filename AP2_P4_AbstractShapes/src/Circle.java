/**
 * Circle ist eine konkrete Shape-Klasse
 * 
 * @author Tim Howe
 */
public final class Circle extends AbstractShape {
	private double radius, area;
	private static double pi = Math.PI;
	/**
	 * Konstruktor
	 * 
	 */
	public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}
	
	public double getArea() {
		area = pi*Math.pow(radius, 2);
		return area;
	}
	
	public String toString() {
		return "Circle."+getName();
	}
	
}
