package pahinave.algorithms.problems.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pahinave.algorithms.datastructures.LinkedList;
import pahinave.algorithms.datastructures.LinkedList.Node;
import pahinave.algorithms.problems.LinkedListInteger;

public class LinkedListIntegerTest {
	@Test
	public void testCreateLinkedListUsingNumber() throws Exception {
		System.out.println("testCreateLinkedListUsingNumber");
		LinkedList list = new LinkedListInteger(12345);
		System.out.println(list);
		Node current = list.getHead();
		for (int i = 5; i >= 1; i--) {
			assertEquals(i, current.getData());
			current = current.getNext();
		}
	}

	@Test
	public void testCreateLinkedListUsingNumber2() throws Exception {
		System.out.println("testCreateLinkedListUsingNumber2");
		LinkedList list = new LinkedListInteger(12);
		System.out.println(list);
		Node current = list.getHead();
		for (int i = 2; i >= 1; i--) {
			assertEquals(i, current.getData());
			current = current.getNext();
		}
	}

	@Test
	public void testCreateLinkedListUsingNumber3() throws Exception {
		System.out.println("testCreateLinkedListUsingNumber3");
		LinkedList list = new LinkedListInteger(1);
		System.out.println(list);
		assertEquals(1, list.getHead().getData());
	}

	@Test
	public void testToNumberWithEmptyList() throws Exception {
		LinkedListInteger list = new LinkedListInteger();
		assertEquals(0, list.toNumber());
	}

	@Test
	public void testToNumberWithSingleDigit() throws Exception {
		LinkedListInteger list = new LinkedListInteger(5);
		assertEquals(5, list.toNumber());
	}

	@Test
	public void testToNumberWithRandomNumber() throws Exception {
		int number = 34252;
		LinkedListInteger list = new LinkedListInteger(number);
		System.out.println(list.toNumber());
		assertEquals(number, list.toNumber());

	}
}
