package junittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTriangle {
	private Triangle tri;

	@Test
	public void test() {
		tri = new Triangle();
		assertEquals(0,tri.triangle(1, 1, 3));
		assertEquals(1,tri.triangle(3, 3, 3));
		assertEquals(2,tri.triangle(2, 3, 3));
		assertEquals(3,tri.triangle(3, 4, 5));
	}

}
