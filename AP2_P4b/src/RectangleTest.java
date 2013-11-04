import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test für die Klasse Rectangle
 * @author Tim Howe
 */
public class RectangleTest extends AbstractShapeTest{

	/*protected IShape s1;
	protected IShape s2;
	protected IShape s3;*/
	
	@Before
	public void setUp() {
		s1 = new Rectangle("a", 5, 5);
		s2 = new Rectangle("b", 7.5, 12.75);
		s3 = new Rectangle("c", 5, 5);
	}
	
	@Test
	public void testArea() {
		double area13 = 5*5;
		double area2 = 7.5*12.75;
		assertEquals(area13, s1.getArea(), 1e-7);
		assertEquals(area2, s2.getArea(), 1e-7);
		assertEquals(area13, s3.getArea(), 1e-7);
		assertEquals(s1.getArea(), s3.getArea(), 1e-7);
	}

	/*
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
		return "Rectangle.";
	}
}
