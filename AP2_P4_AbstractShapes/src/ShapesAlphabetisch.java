import java.util.Comparator;

public class ShapesAlphabetisch implements Comparator<IShape> {
	/**
	 * Klasse zur alphabetischen Vergleich zweier <IShape> Objekte.
	 * @param o1 - Vergleichsobjekt 1
	 * @param o2 - Vergleichsobjekt 1
	 * @return int -1 wenn o1 < o2
	 * @return int 0 wenn o1 == o2
	 * @return int 1 wenn o1 > 02
	 */
	
	public int compare(IShape o1, IShape o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
