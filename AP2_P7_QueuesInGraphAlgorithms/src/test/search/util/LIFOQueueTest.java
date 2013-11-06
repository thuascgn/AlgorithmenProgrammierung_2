package test.search.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import search.util.IQueue;
import search.util.LIFOQueue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class LIFOQueueTest extends AbstractQueueTest {
    
    @Before
    public void setUp() {
        q = new LIFOQueue<Object>();
    }
    
    @Test
    public void testOrdering() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        /*q.put(s2); q.put(s1); q.put(s3); q.put(s1);
        printQueue((LIFOQueue<Object>) q);*/
        
        q.put(s2); q.put(s1); q.put(s3); q.put(s1);
        
        String[] data = new String[4];
        for (int i=0; i<data.length; i++)
        	data[i] = (String) q.get();
    	
        /*printData(data);
        q.put(s2); q.put(s1); q.put(s3); q.put(s1); */
        
        assertSame(s1, data[0]);
        assertSame(s3, data[1]);
        assertSame(s1, data[2]);
        assertSame(s2, data[3]);
    }
        
    @Override
    protected void determineOrderingSequence(List<Object> d) {
        Collections.reverse(d);
    }
    
    /*
    // Helpers
    private void printQueue(LIFOQueue<Object> q) {
    	System.out.println("q.size(): " + q.size());
    	int end = q.size();
    	for (int i = 0; i < end; i++) {
            //data[i] = (String) q.get();
        	System.out.println("q.get("+i+"): " + q.get());
        }
    	System.out.println("q.isEmpty: " + q.isEmpty() );
    }
    private void printData(String[] data) {
    	System.out.println(data.length);
    	int end = data.length;
    	for (int i = 0; i < end; i++) {
            data[i] = (String) q.get();
        	System.out.println("data["+i+"]: " + data[i].toString());
        }
    }*/
}
