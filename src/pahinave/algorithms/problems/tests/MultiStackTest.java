package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.MultiStack;

public class MultiStackTest {
	@Test
	public void testMultiStack() throws Exception {
		MultiStack stack = new MultiStack(4);

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);

		stack.push(21);
		stack.push(22);

		Assert.assertEquals(22, stack.pop());
		Assert.assertEquals(13, stack.pop(1));
		Assert.assertEquals(4, stack.pop(0));

		// empty non-latest stack and make sure its removed from stack list
		Assert.assertEquals(3, stack.pop(0));
		Assert.assertEquals(2, stack.pop(0));
		Assert.assertEquals(1, stack.pop(0));

		// stack no 1 is now stack no 0
		Assert.assertEquals(12, stack.pop(0));

		// stack no 1 is latest stack
		Assert.assertEquals(21, stack.pop());

		// stack 0 is only stack remaining
		Assert.assertEquals(11, stack.pop());
		Assert.assertEquals(10, stack.pop());

		// Nothing in the stack
		Assert.assertEquals(-1, stack.pop());
		// NOthing in the stack 0
		Assert.assertEquals(-1, stack.pop(0));
		// Stack 1- does not exist
		Assert.assertEquals(-1, stack.pop(1));

	}
}
