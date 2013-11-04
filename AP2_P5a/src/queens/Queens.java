package queens;

import java.io.Console;

/**
 * Erzeugt eine Loesung des N-Damen Problems und stellt sie graphisch dar.
 * 
 * @author E. Ehses, FH Koeln
 */
public class Queens {
    private static final int NUMBER_OF_QUEENS = 8;
    private static Display display;
    static int recursionDepth;
    //static int[] solutions;
    
    /**
     * Initialisiert alle noetigen Objekte und ruft die Loesungssuche auf.
     * 
     * @param args
     */
    public static void main(String[] args) {
    	recursionDepth = 0;
    	
        BoardWithQueens b = new BoardWithQueens(NUMBER_OF_QUEENS);
        display = new Display(b);
        if (solvable(b)) {
        	//addSolution(b);
            System.out.println("Die Loesung lautet: " + b);
        } else {
            System.out.println("Es gibt keine Loesung!");
        }
    }

    /**
     * Rekursiver Backtracking Algorithmus zur Loesung des N-Damen Problems.
     * 
     * @param board
     *            das Brett mit den plazierten Damen
     * @return <tt>true</tt> wenn eine Loesung gefunden wurde
     */
    private static boolean solvable(BoardWithQueens board) {
    	//recursionDepth++;
        System.out.println(board.toString() + "  |  recursionDepth: " + recursionDepth);
        if (board.numberOfPlacedQueens() == NUMBER_OF_QUEENS) {
        	// if loesung ok =>
        	return true;
        } else {
        	for (int i=0; i < 8; i++) {
        		if (board.isSafe(i)){
        			board.placeNextQueen(i);
        			displayAndWait(0.025);
        			if (solvable(board)){
        				return true;
        			} else {
        				board.removeLastQueen();
        				displayAndWait(0.025);
        			}
        		}
        	}
        }
        return false;
    }

    /**
     * Bewirkt eine Aktualisierung der Graphik und wartet die angegebene Zeit.
     * 
     * @param secs
     *            Wartezeit in Sekunden
     */
    private static void displayAndWait(double secs) {
        try {
            display.setNewState();
            Thread.sleep((int) (secs * 1e3));
        } catch (InterruptedException canNeverHappen) {
        }
    }
    
    /**
     * Fügt die aktuelle Lösung dem LösungsArray hinzu
     */
    private static void addSolution(BoardWithQueens board){
    	//int solIndex = solutions.length + 1;
    	System.out.println(board.toString());
    	/*solutions[solIndex] = board.getQueens();*/
    	//System.out.println("Solutions: " + solutions);
    }
}
