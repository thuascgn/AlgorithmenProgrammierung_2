package sorting;
public class Bubblesort implements IntSort {
    /**
     * Der Algorithmus BubbleSort (direktes Vertauschen) funktioniert wie folgt:
     * <p>
     * Fuer jeden Durchlauf der aeusseren Schleife geht man beginnend mit a[i]
     * durch. Dabei vergleicht man 2 aufeinanderfolgende Feldinhalte und 
     * vertauscht sie, falls sie in der falschen Reihenfolge stehen.
     * <p>
     * Ein korrekter Ablauf wird durch die folgenden Ausgaben dargestellt:
     * <pre>
     * BubbleSort: [7, 1, 6, 2, 3, 8, 4, 5| ] 
     * BubbleSort: [1, 6, 2, 3, 7, 4, 5| 8] 
     * BubbleSort: [1, 2, 3, 6, 4, 5| 7, 8] 
     * BubbleSort: [1, 2, 3, 4, 5| 6, 7, 8] 
     * BubbleSort: [1, 2, 3, 4| 5, 6, 7, 8] 
     * BubbleSort: [1, 2, 3| 4, 5, 6, 7, 8] 
     * BubbleSort: [1, 2| 3, 4, 5, 6, 7, 8] 
     * BubbleSort: [1, 2, 3, 4, 5, 6, 7, 8]
     * </pre>
     * Der Strich | trennt den unsortierten von dem sortierten Teil.
     */
    public void sort(int[] a) {
    	int i,j,t;
    	int vergl = 0;
    	int tausch = 0;
    	
    	/* Laufrichtung rechts > links */
    	for (i=a.length; i>1; i--) {
    		Tracer.direct(a, i);
    		for (j=1; j<i; j++) {
    			vergl++;
    			if(a[j-1] > a[j]){
    				t = a[j-1];
    				a[j-1] = a[j];
    				a[j] = t;
    				tausch++;
    			}
    		}
    	}
    	//System.out.print("v/t " + vergl + "/" + tausch + " ");
    	Tracer.array(a);
    	
    	
    	/* Laufrichtung links > rechts
    	for (i=0; i < a.length; i++){
    		Tracer.direct(a, i);
    		for (j=i+1; j < a.length; j++){
    			if (a[j] < a[i]) { 
    				t = a[i]; 
    				a[i] = a[j];
    				a[j] = t;
    				}
    			}
    		}
    	Tracer.array(a);
    	*/
    }
}
