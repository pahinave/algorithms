package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.QueueWithTwoStacks;

public class QueueWithTwoStacksTest {
	@Test
	public void test() throws Exception {
		QueueWithTwoStacks q = new QueueWithTwoStacks();
		Assert.assertEquals(-1, q.remove());
		q.add(1);
		q.add(2);
		Assert.assertEquals(1, q.remove());
		q.add(3);
		Assert.assertEquals(2, q.remove());
		Assert.assertEquals(3, q.remove());
		Assert.assertEquals(-1, q.remove());
	}
}
