package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.NQueensProblem;

public class NQueensProblemTest {
	@Test
	public void test1() throws Exception {
		NQueensProblem q = new NQueensProblem(1);
		q.solve();
		Assert.assertEquals(1, q.getSolutions().size());
	}

	@Test
	public void test3() throws Exception {
		NQueensProblem q = new NQueensProblem(3);
		q.solve();
		Assert.assertEquals(0, q.getSolutions().size());
	}

	@Test
	public void test4() throws Exception {
		NQueensProblem q = new NQueensProblem(4);
		q.solve();
		Assert.assertEquals(2, q.getSolutions().size());
	}

	@Test
	public void test5() throws Exception {
		NQueensProblem q = new NQueensProblem(5);
		q.solve();
		Assert.assertEquals(10, q.getSolutions().size());
	}

	@Test
	public void test8() throws Exception {
		NQueensProblem q = new NQueensProblem(8);
		q.solve();
		Assert.assertEquals(92, q.getSolutions().size());
	}

}
