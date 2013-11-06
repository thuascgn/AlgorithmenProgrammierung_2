package util;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Doppelt verkettete zirkuläre Liste.
 */
public class LinkedObjects implements Iterable<Object> {
    /*
     * Invariante:
     * head zeigt auf dem Kopfknoten der Liste
     * head.next zeigt auf den ersten Listenknoten
     * head.prev zeigt auf den letzten Listenknoten
     * head.obj = null
     * fuer jeden Listenknoten k zeigt
     *     k.obj auf das gespeicherte Objekt
     *     k.prev auf den Vorgaenger
     *     k.next auf den Nachfolger
     * Vor dem ersten Knoten ist head und nach dem letzten Knoten ist head.
     * In einer leeren Liste zeigt der Head-Knoten auf sich selbst.
     * 
     */
    private static class Link {
        final Object obj;
        Link next;
        Link prev;

        /**
         * Wird nur bei der Initialisierung aufgerufen!
         */
        Link() {
            obj = null;
            this.next = this.prev = this;
        }

        /**
         * Erzeugt einen neuen Knoten.
         * @param obj   gespeicherter Inhalt
         * @param prev  Vorgaenger
         * @param next  Nachfolger
         */
        Link(Object obj, Link prev, Link next) {
            this.obj = obj;
            this.prev = prev;
            this.next = next;
            
        }
    }
    private final Link head = new Link();
    
    // Fuegt am Ende hinzu
    public void add(Object obj) {
    	Link l = head.prev;
    	Link m = new Link(obj, l, head);
    	l.next = m;
    	head.prev = m;
    }
    
    public void addFirst(Object obj) {
    	Link l = head.next;
    	Link m = new Link(obj, head, l);
    	head.next = m;
    	l.prev = m;
    	
    }
    
    /**
     * Entfernt das erste Object und ibt es zur�ck
     * Object o = head.next.obj; Link m = new Link(head.next.next.obj, head, head.next.next.next);
     * return o
     * @return Object das erste Objekt
     */
    public Object removeFirst() {
    	if (isEmpty()) throw new NoSuchElementException();
    	Link l = head.next;
    	Link m = new Link(l.next.obj, head, l.next.next);
    	head.next = m;
        return l.obj;
    }
    
    /**
     * Entfernt das letzte Objekt und gibt es zur�ck
     * Object o = head.prev.obj; Link m = new Link(head.prev.prev.obj, head.prev.prev.prev, head);
     * return o;
     * @return
     */
    public Object removeLast() {
    	if (isEmpty()) throw new NoSuchElementException();
    	Link l = head.prev;
    	Link m = new Link(l.prev.obj, l.prev.prev, head);
    	head.prev = m;
        return l.obj;
    }

    public boolean isEmpty() {
        return (head.next.equals(head)) ? true : false;
    }
 
    
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            public Link current = head.next;
        
            public boolean hasNext() {
            	/*System.out.println("hasNext: " + current.toString() + "/" + head.toString() + 
            			"  |  " + (current!=head) + " && " + (current!=null) + "  =  "
            			+ (current!=head && current != null));*/
            	return (current != head && current != null);
            }
            
            public Object next() {
            	if (current == head) throw new NoSuchElementException();
            	Link l = current;
            	current = l.next;
            	//current = current.next;
            	return l.obj;
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
