package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.NumberOfOpenDoors;

public class NumberOfOpenDoorsTest {

	@Test
	public void test1() {
		NumberOfOpenDoors o = new NumberOfOpenDoors();
		Assert.assertEquals(1, o.numberOfOpenDoors(1));
	}

	@Test
	public void test2() {
		NumberOfOpenDoors o = new NumberOfOpenDoors();
		Assert.assertEquals(1, o.numberOfOpenDoors(2));
	}

	@Test
	public void test3() {
		NumberOfOpenDoors o = new NumberOfOpenDoors();
		Assert.assertEquals(5, o.numberOfOpenDoors(9));
	}
}
