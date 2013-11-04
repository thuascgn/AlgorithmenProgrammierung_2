package sorting;

public class Quicksort implements IntSort {
	
	/*
	 * Die übergebene Folge wird anhand eines Pivot Elements x 
	 * in zwei teile a, b zerlegt wobei für alle x in a <= b
	 * 
	 * 
	 */
	private int[] a;
	private int n;
	
	public void sort(int[] a) {
		this.a = a;
		n = a.length;
		quicksort(0, n-1);
	}
	private void quicksort(int lo, int hi) {
		int i=lo, j=hi;
		//pivot x
		int x = a[(lo+hi)/2];
		Tracer.direct(a, i);
		//System.out.println("i/j/x: " + i + "/"+ j + "/" + x);
		while(i<=j) {
			while (a[i] < x) i++;
			while (a[j] > x) j--;
			if (i<=j) {
				// Tauschen
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
				j--; i++;
				Tracer.direct(a, i);
			}
		}
		if (lo<j) quicksort(lo, j);
		if (i<hi) quicksort(i, hi);
	}

}
