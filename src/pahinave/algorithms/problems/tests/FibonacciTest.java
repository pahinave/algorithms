package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.Fibonacci;

public class FibonacciTest {

	@Test
	public void test0thFib() {
		Fibonacci f = new Fibonacci();
		Assert.assertEquals(0, f.fibonacci(0));
	}

	@Test
	public void test1stFib() {
		Fibonacci f = new Fibonacci();
		Assert.assertEquals(1, f.fibonacci(1));
	}

	@Test
	public void test2ndFib() {
		Fibonacci f = new Fibonacci();
		Assert.assertEquals(1, f.fibonacci(2));
	}

	// 0 1 1 2 3 5 8 13 21 34
	@Test
	public void test9thstFib() {
		Fibonacci f = new Fibonacci();
		Assert.assertEquals(34, f.fibonacci(9));
	}
}
