package search.util;

import java.util.AbstractList;
import java.util.Iterator;

/**
 * Die Klasse FListrealisiert eine unveraenderliche Liste. 
 * FList steht fuer "Functional List". Veraenderung sind nur moeglich, indem
 * ueber die cons-Operation neue erweiterte Listen erzeugt werden. Andere
 * Operationen zum Erzeugen veraenderter Liste (Teillisten, Loeschen von
 * Elementen, Append, ...) sind nicht implementiert.
 * <p>
 * Die veraendernden Operationen der Schnittstelle List erzeugen eine
 * <tt>UnsupportedOperationException</tt>.
 * <p>
 * FLists sind so implementiert, dass nach der cons-Operation die Ausgangsliste
 * und die neue Liste sich die gemeinsamen Daten teilen.
 * <p>
 * Alle Operationen der Schnittstelle <code>List</code> die einen wahlfreien
 * Zugriff auf einzelne Listenelemente erlauben und auch die Iteration ueber
 * einen <code>ListIterator</code> sind sehr ineffizient.
 * <p>
 * Zugriffe auf das erste Element und die Iteration ueber einen einfachen
 * <code>Iterator</code> sind effizient.
 * 
 * @author Erich Ehses
 */
public final class FList<T> extends AbstractList<T> {
    private final Entry<T> first;
    private final int size;

    /**
     * Erzeugt eine leere Liste.
     */
    public FList() {
        first = null;
        size = 0;
    }
    
    /**
     * Erzeugt eine List aus n Werten
     * @param elements zu speichernde Werte
     * @return neue Liste
     */
    //@SafeVarargs        // in Java 5 nicht definiert!
    public static <T> FList<T> create(T... elements) {
        FList<T> lst = new FList<T>();
        for (int i = elements.length - 1; i >= 0; i--)
            lst = lst.cons(elements[i]);
        return lst;
    }
    
    /**
     * Erzeugt eine neue Liste, in der element an den
     * Anfang der Liste gesetzt wurde.
     * 
     * @param element neues Head-Element.
     */
    public FList<T> cons(T element) {
         return new FList<T>(element, this);
    }

    /**
     * Privater Konstruktor zum Erzeugen einer erweiterten Lsite
     * @param head neuer anfangswert
     * @param tail Ausgangsliste
     */
    private FList(T head, FList<T> tail) {
        first = new Entry<T>(head, tail.first);
        size = tail.size + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new FListIterator<T>(first);
    }

    public int size() {
        return size;
    }

    /**
     * Gibt das erste Listenelement zurück.
     * 
     * @return erstes Element.
     */
    public T getFirst() {
        return first.value;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Entry<T> p = first;
        for (int i = 0; i < index; i++)
            p = p.next;
        return p.value;
    }

    /**
     * Die Klasse stellt ein Element der Liste dar. Die öffentlichen Methoden
     * erlauben den Zugriff aber keine Veränderung.
     */
    private static class Entry<T> {
        final T value;
        final Entry<T> next;

        Entry(T value, Entry<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Implementierung eines passenden Iterators.
     */
    private static class FListIterator<T> implements Iterator<T> {
        Entry<T> p;

        FListIterator(Entry<T> first) {
            p = first;
        }

        public boolean hasNext() {
            return p != null;
        }

        public T next() {
            T result = p.value;
            p = p.next;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}