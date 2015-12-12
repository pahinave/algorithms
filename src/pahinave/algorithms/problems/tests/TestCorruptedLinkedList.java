package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.datastructures.LinkedList;
import pahinave.algorithms.datastructures.LinkedList.Node;
import pahinave.algorithms.problems.CorruptedLinkedList;

public class TestCorruptedLinkedList {
	@Test
	public void findCircularListStartNoCirular() {
		// 7 6 5 4 3 2 1
		LinkedList list = new LinkedList();
		for (int i = 7; i > 0; i--) {
			list.insert(i);
		}

		CorruptedLinkedList c = new CorruptedLinkedList();
		Node startOfLoop = c.findCircularListStart(list);
		Assert.assertNull(startOfLoop);
	}

	@Test
	public void findCircularListStartOddCircleOddHeadStart() {
		// 8 7 6 5 4 3 2 1->5 (fast 3 nodes ahead when slow enters the circle)
		LinkedList list = new LinkedList();
		Node end = list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		Node loopStart = list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);	
		// add circle
		end.setNext(loopStart);

		CorruptedLinkedList c = new CorruptedLinkedList();
		Node startOfLoop = c.findCircularListStart(list);
		Assert.assertSame(loopStart, startOfLoop);
	}

	@Test
	public void findCircularListStartOddCircleEvenHeadStart() {
		// 7 6 5 4 3 2 1->5 (fast 2 nodes ahead when slow enters the circle)
		LinkedList list = new LinkedList();
		Node end = list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		Node loopStart = list.insert(5);
		list.insert(6);
		list.insert(7);
		// add circle
		end.setNext(loopStart);

		CorruptedLinkedList c = new CorruptedLinkedList();
		Node startOfLoop = c.findCircularListStart(list);
		Assert.assertSame(loopStart, startOfLoop);
	}

	@Test
	public void findCircularListStartEvenCircleOddHeadStart() {
		// 7 6 5 4 3 2 1->6 (fast 1 nodes ahead when slow enters the circle)
		LinkedList list = new LinkedList();
		Node end = list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		Node loopStart = list.insert(6);
		list.insert(7);
		// add circle
		end.setNext(loopStart);

		CorruptedLinkedList c = new CorruptedLinkedList();
		Node startOfLoop = c.findCircularListStart(list);
		Assert.assertSame(loopStart, startOfLoop);
	}

	@Test
	public void findCircularListStartEvenCircleEvenHeadStart() {
		// 8 7 6 5 4 3 2 1->6 (fast 2 nodes ahead when slow enters the circle)
		LinkedList list = new LinkedList();
		Node end = list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		Node loopStart = list.insert(6);
		list.insert(7);
		list.insert(8);	
		// add circle
		end.setNext(loopStart);

		CorruptedLinkedList c = new CorruptedLinkedList();
		Node startOfLoop = c.findCircularListStart(list);
		Assert.assertSame(loopStart, startOfLoop);
	}

	@Test
	public void findCircularListInFullyCircularList() {
		// 8 7 6 5 4 3 2 1->8
		LinkedList list = new LinkedList();
		Node end = list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		Node loopStart = list.insert(8);	
		// add circle
		end.setNext(loopStart);

		CorruptedLinkedList c = new CorruptedLinkedList();
		Node startOfLoop = c.findCircularListStart(list);
		Assert.assertSame(loopStart, startOfLoop);
	}

}
