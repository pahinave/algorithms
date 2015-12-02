package pahinave.algorithms.dynamicprogramming.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pahinave.algorithms.dynamicprogramming.OptimalBST;

public class OptimalBSTTest {
	@Test
	public void test1() throws Exception {

		int[] freq = new int[] { 0, 40, 5, 15, 5, 10, 25 };

		OptimalBST o = new OptimalBST();
		int actual = o.solve(freq);
		assertEquals(210, actual);
	}

	@Test
	public void test2() throws Exception {

		int[] freq = new int[] { 0, 10, 20, 30, 40 }; // 180

		OptimalBST o = new OptimalBST();

		int actual = o.solve(freq);
		assertEquals(180, actual);

	}

	@Test
	public void test3() throws Exception {
		int[] freq = new int[] { 0, 1, 34, 33, 32 }; // 168

		OptimalBST o = new OptimalBST();

		int actual = o.solve(freq);
		assertEquals(168, actual);
	}
}
