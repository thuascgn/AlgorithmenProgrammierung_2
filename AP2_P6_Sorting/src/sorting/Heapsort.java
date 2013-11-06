package sorting;

public class Heapsort implements IntSort{
	private int[] a;
	private int n;
	
	public void sort(int[] a) {
		this.a=a;
		n=a.length;
		heapsort();
	}
	
	public void heapsort(){
		buildheap();
		while (n>1) {
			n--;
			exchange(0, n);
			downheap(0);
		}
	}
	public void buildheap() {
		// ab der mitte des Arrays absteigend
		for (int v=(n/2)-1; v>=0; v--){
			// übergebe absteigenden index an downheap
			downheap(v);
		}
	}
	public void downheap(int v) {
		// w erster Nachfolger von v
		int w = (2*v)+1;
		while(w<n) {
			if(w+1<n) {
				if (a[w+1] > a[w]) w++; 
				if (a[v] >= a[w]){ 
					return; 
				} else {
					exchange(v,w); // v und w vertauschen
					// v = w fortfahren
					v=w;
					w=(2*v)+1;
				}
			}
		}
	}
	private void exchange(int v, int w) {
		Tracer.direct(a, v);
		int t= a[v];
		a[v] = a[w];
		a[w] = t;
	}
}
