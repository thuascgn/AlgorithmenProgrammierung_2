package objects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBlackToken extends AbstractTestToken {
	@Before
	public void setUp() {
		object = BlackToken.instance();
	}

	@Test
	public void isBlack() {
		assertTrue(object.isBlack());
	}
	
	@Test
	public void unchanged() {
        assertSame(object, object.nextGeneration(ts2));
		assertSame(object, object.nextGeneration(ts3));
	}

	@Test
	public void changed() {
		assertEquals(W, object.nextGeneration(ts1));
		assertEquals(W, object.nextGeneration(ts4));
	}
}
