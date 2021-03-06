package search.util;

//import java.util.Comparator;
//import java.util.List;
import java.util.NoSuchElementException;
import java.util.LinkedList;

public final class LIFOQueue<T> implements IQueue<T> {
	
	private LinkedList<T> data;
	private int size;
	

	public LIFOQueue(){
		this.data = new LinkedList<T>();
		this.size = 0;
	}
	
	public void put(T p) {
		data.addFirst(p);
		size++;
	}
	
	@SuppressWarnings("unchecked")
	public T get() {
		if (size<=0) 
			throw new NoSuchElementException();
		size--;
		return data.remove(0); 
	}
	
	public T peek() {
		return data.element();
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		for (int i=0; i<size; i++) {
			data.set(i, null);
		}
		size = 0;
	}

	@Override
	public void printData(String m) {
		// TODO Auto-generated method stub
		
	}
}
