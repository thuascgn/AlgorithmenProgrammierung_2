package shapes;
import static org.junit.Assert.*;

import java.util.Comparator;
import org.junit.Test;


public class ShapesAlphabetischTest {
    @Test
    public void testCompare() {
        Comparator<IShape> c = new ShapesAlphabetisch();
        Circle c1 = new Circle("alfa", 10.0);
        Circle c2 = new Circle("delta", 10.0);
        Circle c3 = new Circle("epsilon", 10.0);
        Circle c4 = new Circle("3000", 10.0);
        Rectangle r1 = new Rectangle("beta", 10, 20);
        Rectangle r2 = new Rectangle("alfa", 10, 20);
        assertTrue(c.compare(c1, r2) == 0);
        assertTrue(c.compare(r2, c1) == 0);
        assertTrue(c.compare(c1, c2) < 0);
        /*System.out.println(c.compare(c1, c2));
        System.out.println(c.compare(c1, c3));
        System.out.println(c.compare(c3, c1));
        System.out.println(c.compare(c1, c4));*/
        assertTrue(c.compare(c1, c2) == -3);
        assertTrue(c.compare(c3, c1) == 4);
        assertTrue(c.compare(c1, c4) == 46);
        assertTrue(c.compare(c1, r1) < 0);
        assertTrue(c.compare(r1, r2) > 0);
    }
}
