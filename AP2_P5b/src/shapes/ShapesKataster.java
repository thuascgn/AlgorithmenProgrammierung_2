package shapes;

import java.util.Comparator;

public class ShapesKataster implements Comparator<IShape> {
	/**
	 * NUmerischer Vergleich der Fläche zweier <iShape> Objekte. 
	 * @param s1, s2
	 * @return int -1 {s1 - s2 < 0}
	 * @return int 0 {s1 - s2 = 0}
	 * @return int 1 {s1 - s2 > 0}
	 */
	
	public int compare(IShape s1, IShape s2) {
		return (int) Math.signum(s1.getArea() - s2.getArea());
	}
}
