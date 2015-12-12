package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.MinStack;

public class MinStackTest {
	@Test
	public void minFromStack() {
		MinStack s = new MinStack();
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(7);
		s.push(10);
		s.push(6);
		s.push(0);
		s.push(100);
		
		Assert.assertEquals(0, s.min());
		s.pop(); Assert.assertEquals(0, s.min());
		s.pop(); Assert.assertEquals(2, s.min());
		s.pop(); Assert.assertEquals(2, s.min());
		s.pop(); Assert.assertEquals(2, s.min());
		s.pop(); Assert.assertEquals(2, s.min());
		s.pop(); Assert.assertEquals(3, s.min());
		s.pop(); Assert.assertEquals(4, s.min());
		s.pop(); Assert.assertEquals(-1, s.min());
	}
}
