package shapes;

import java.util.Comparator;

public class ShapesAlphabetisch implements Comparator<IShape> {
	/**
	 * Alphabetische Vergleich der Name Strings zweier <iShape> Objekte. Gibt die
	 * Differenz im alphabetischen/ASCII Index des ersten ungleichen chars im Name String
	 * aus.
	 * @param s1, s2
	 * @return int -x {s1 < s2}
	 * @return int 0 {s1 == s2}
	 * @return int +x {s1 > s2}
	 */
	
	public int compare(IShape s1, IShape s2) {
		return s1.getName().compareTo(s2.getName());
	}
}
