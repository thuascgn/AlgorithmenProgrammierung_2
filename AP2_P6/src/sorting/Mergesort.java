package sorting;

public class Mergesort implements IntSort{
	private int[] a;
	private int[] b;
	private int n;
	
	/*
	 * Die zu sortierende Folge wird in zwei hälften geteilt die
	 * jeweils für sich sortiert und wieder zusammengesetzt werden
	 */
	public void sort (int[] a){
		this.a = a;
		n = a.length;
		b = new int[n];
		Tracer.array(a);
		mergesort(0,n-1);		
	}
	private void mergesort(int lo, int hi){
		if (lo<hi){
			int m = (lo+hi)/2;
			mergesort(lo,m);
			mergesort(m+1,hi);
			merge(lo,m,hi);
		}
	}
	private void merge(int lo, int m, int hi){
		int i,j,k;
		for (i=lo;i<=hi;i++) {
			b[i]=a[i];
		}
		
		i=lo; j=m+1; k=lo;
		while(i<=m && j<=hi){
			if(b[i]<=b[j]){
				a[k++] = b[i++];
				Tracer.direct(a, k);
			} else {
				a[k++] = b[j++];
				Tracer.direct(a, k);
			}
		}
		while (i<=m) { a[k++] = b[i++]; Tracer.direct(a,k);}
	}
	
}
