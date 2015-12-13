package pahinave.algorithms.problems.tests;

import org.junit.Test;

import pahinave.algorithms.problems.TowerOfHonoi;

public class TowerOfHonoiTest {
	@Test
	public void test() throws Exception {
		TowerOfHonoi toh = new TowerOfHonoi();
		toh.solve(3);
	}
}
