package test.search.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class PriorityQueueTest extends AbstractQueueTest implements Comparator<Object> {

    @Before
    public void setUp() {
        q = new search.util.PriorityQueue<Object>(2000, this);
    }
    
    @Test
    public void testOrdering() {
        Double d1 = new Double(1.1);
        Double d2 = new Double(2.2);
        Double d3 = new Double(3.3);
        q.put(d2);
        q.put(d1);
        q.put(d3);
        q.put(d1);

        Double[] data = new Double[4];
        for (int i=0; i<data.length; i++){
        	data[i] = (Double) q.get();
        }
        
        q.put(d2); q.put(d1); q.put(d3); q.put(d1); 
        for (int i=0; i<data.length; i++){
        	System.out.println("d["+i+"]: " + data[i] + " | q.get(): " + q.get());
        }

        q.put(d2); q.put(d1); q.put(d3); q.put(d1);
        assertSame(d1, q.get());
        assertSame(d1, q.get());
        assertSame(d2, q.get());
        assertSame(d3, q.get());
 
    }
    
    @Test
    public void testOrdering2(){
        Double d1 = new Double(1.1);
        Double d2 = new Double(2.2);
        Double d3 = new Double(3.3);
        Double d4 = new Double(4.44);
        
        q.put(d3); q.put(d2); q.put(d3); q.put(d4);
        q.put(d1); q.put(d2); q.put(d1);
    	
        Double[] data = new Double[7];
        for (int i=0; i<data.length; i++){
        	data[i] = (Double) q.get();
        }
        
        q.put(d3); q.put(d2); q.put(d3); q.put(d4);
        q.put(d1); q.put(d2); q.put(d1);
        //q.printData("testOrdering2");
        System.out.println("-----");
        for (int i=0; i<data.length; i++){
        	System.out.println("d["+i+"]: " + data[i] + " | q.get(): " + q.get()); }
        
        System.out.println("-----Rev-Put-----");
        for (int i=data.length-1; i>=0; i--){ 
        	q.printData("rev lp begin"+i); q.put(data[i]); q.printData("rev lp end"+i); 
        	}
        //q.printData("testOrdering2");
        
        for (int i=0; i<data.length; i++){
        	System.out.println("d["+i+"]: " + data[i] + " | q.get(): " + q.get()); }
        System.out.println("-----");
        
        q.put(d3); q.printData("put d3");
        q.put(d2); q.printData("put d2");
        q.put(d3); q.printData("put d3");
        q.put(d4); q.printData("put d4");
        q.put(d1); q.printData("put d1");
        q.put(d2); q.printData("put d2");
        q.put(d1); q.printData("put d1");
        //q.printData("testOrdering2");
        //System.out.println("-----");
        assertFalse("Queue nicht leer.", q.isEmpty());
        assertSame(d1, q.get());
        assertSame(d1, q.get());
        assertSame(d2, q.get());
        assertSame(d2, q.get());
        assertSame(d3, q.get());
        assertSame(d3, q.get());
        assertSame(d4, q.get());
        assertTrue("Queue ist leer.", q.isEmpty());
    }
    
    @Test
    public void testPutGetOne() {
        Double d = new Double(2.3);
        q.put(d);
        assertFalse("Queue ist nicht leer.", q.isEmpty());
        assertSame(d, q.get());
        assertTrue("Queue muss leer sein.", q.isEmpty());
    }
    
   
    /*@Override
    public void testRandomData() {
        ArrayList<Object> data = new ArrayList<Object>();
        for (int i = 0; i < 1000; i++) {
            Double d = new Double(Math.random());
        	data.add(d);
            q.put(d);
        }
        determineOrderingSequence(data);
        for (Object number : data) {
            assertEquals(number, q.get());
        }
        assertTrue("muss leer sein.", q.isEmpty());
    }
    */
    
    @Override
    protected void determineOrderingSequence(List<Object> d) {
        Collections.sort(d, this);
    }

    /**
     * o1 > o2 = 1
     * o2 = o2 = 0
     * o1 < o2 = -1
     */
    public int compare(Object o1, Object o2) {
    	int c = ((Double) o1).compareTo((Double) o2);
    	//System.out.println("cmp: " + (Double) o1 + " / " + (Double) o2 + "  -> " + c);
        return c;
    }
    //
}
