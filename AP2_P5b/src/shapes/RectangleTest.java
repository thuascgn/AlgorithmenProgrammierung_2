package shapes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test fuer die Klasse Circle.
 */
public class RectangleTest extends AbstractShapeTest{
    /*protected IShape s1;
    protected IShape s2;
    protected IShape s3;*/

    @Before
    public void setUp() {
        s1 = new Rectangle("a", 10.25, 10.25);
        s2 = new Rectangle("b", 16.5, 9.5);
        s3 = new Rectangle("c", 10.25, 10.25);
    }
    
    @Test
    public void testArea() {
        double area13 = 10.25 * 10.25;
        double area2 = 16.5 * 9.5;
        
        assertEquals(area13, s1.getArea(), 1e-7);
        assertEquals(area2, s2.getArea(), 1e-7);
        assertEquals(area13, s3.getArea(), 1e-7);
    }
    
    protected String prefix() {
        return "Rectangle.";
    }
}
