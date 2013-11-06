package objects;

/**
 * Ein Feld mit der Anfangsbelegung
 * <pre>
 *    xx
 *     xx
 *     x
 * </pre>
 */
class Pentomino extends AbstractWorld {
	Pentomino(int nx, int ny) {
		super(nx, ny);
		int hnx = nx/2;
		int hny = ny/2;
		set(hnx, hny, BlackToken.instance());
		set(hnx+1, hny, BlackToken.instance());
		set(hnx, hny-1, BlackToken.instance());
		set(hnx-1, hny-1, BlackToken.instance());
		set(hnx, hny+1, BlackToken.instance());
		
	}
}
