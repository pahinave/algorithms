package pahinave.algorithms.datastructures.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.datastructures.LinkedList;
import pahinave.algorithms.datastructures.LinkedList.Node;

public class LinkedListTest {

	@Test
	public void testRemoveDuplicatesRandomNumbers() {
		LinkedList list = new LinkedList();
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			list.insert(r.nextInt(10));
		}
		System.out.println(list);
		list.removeDuplicates();
		System.out.println(list);

		// create set out of list elements
		// if any number repeats, then size of set
		// and list will be different
		Set<Integer> result = new HashSet<>();
		Node current = list.getHead();
		while (current != null) {
			result.add(current.getData());
			current = current.getNext();
		}

		Assert.assertEquals(result.size(), list.size());
	}

	@Test
	public void testReverse() throws Exception {
		System.out.println("testReverse");
		LinkedList list = new LinkedList();
		for (int i = 1; i <= 10; i++) {
			list.insert(i);
		}
		System.out.println(list);
		list.reverse();
		System.out.println(list);

		Node current = list.getHead();
		for (int i = 1; i <= 10; i++) {
			assertEquals(i, current.getData());
			current = current.getNext();
		}

	}
	
	@Test
	public void removeFromEmptyList() {
		LinkedList list = new LinkedList();
		Assert.assertEquals(-1, list.remove());
	}
	
	@Test
	public void removeFromSingleItemList() {
		LinkedList list = new LinkedList();
		list.insert(1);
		
		Assert.assertEquals(1, list.remove());
		Assert.assertEquals(-1, list.remove());
	}
	
	@Test
	public void removeFrom2OrMoreItemList() {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		Assert.assertEquals(3, list.remove());
		Assert.assertEquals(2, list.remove());
		Assert.assertEquals(1, list.remove());
		Assert.assertEquals(-1, list.remove());
	}
	
	@Test
	public void removeFromListWithPushPop() {
		LinkedList list = new LinkedList();
		list.insert(1);
		int data_1 = list.remove();
		int data_minus_1 = list.remove();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		int data_4 = list.remove();
		int data_3 = list.remove();
		list.insert(5);
		int data_5 = list.remove();
		Assert.assertEquals(1, data_1);
		Assert.assertEquals(-1, data_minus_1);
		Assert.assertEquals(3, data_3);
		Assert.assertEquals(4, data_4);
		Assert.assertEquals(5, data_5);
		
	}

}
