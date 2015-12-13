package pahinave.algorithms.problems.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;

import pahinave.algorithms.problems.SortStack;

public class SortStackTest {
	@Test
	public void test() throws Exception {
		LinkedList<Integer> source = new LinkedList<>();
		Random r = new Random();
		for(int i=0; i<20; i++) {
			source.add(r.nextInt(10));
		}
		SortStack ss = new SortStack();
		LinkedList<Integer> sorted = ss.sort(source);
		
		assertEquals(20, sorted.size());
		int prev = Integer.MIN_VALUE;
		
		System.out.print("Sorted:");
		while(sorted.size() > 0) {
			int item = sorted.pop();
			assertTrue(prev <= item);
			prev = item;
			System.out.print(item + " ");
		}
	}
}
