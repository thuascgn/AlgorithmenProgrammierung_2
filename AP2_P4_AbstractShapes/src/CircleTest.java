import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test für die Klasse Circle.
 * @author unknown
 */
public class CircleTest extends AbstractShapeTest{
    /*protected IShape s1;
    protected IShape s2;
    protected IShape s3;*/

    @Before
    public void setUp() {
        s1 = new Circle("a", 10.5);
        s2 = new Circle("b", 11.0);
        s3 = new Circle("c", 10.5);
    }
    
    @Test
    public void testArea() {
        double area13 = Math.PI * 10.5 * 10.5;
        double area2 = Math.PI * 11.0 * 11.0;
        
        assertEquals(area13, s1.getArea(), 1e-7);
        assertEquals(area2, s2.getArea(), 1e-7);
        assertEquals(area13, s3.getArea(), 1e-7);
    }
    /*
    @Test
    public void testName() {
        assertEquals("a", s1.getName());
        assertEquals("b", s2.getName());
        assertEquals("c", s3.getName());
    }

    @Test
    public void testCompare() {
        assertTrue(s1.compareTo(s3) == 0);
        assertTrue(s3.compareTo(s1) == 0);
        assertTrue(s1.compareTo(s2) < 0);
        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s2) < 0);
        assertTrue(s2.compareTo(s3) > 0);
    }

    @Test
    public void testEquals() {
        assertFalse(s1.equals(s2));
        assertFalse(s1.equals(s3));
        assertFalse(s3.equals(s2));
    }

    @Test
    public void testToString() {
        String p = prefix();
        assertEquals(p + "a", s1.toString());
        assertEquals(p + "b", s2.toString());
        assertEquals(p + "c", s3.toString());
    }
    */
    protected String prefix() {
        return "Circle.";
    }
}
