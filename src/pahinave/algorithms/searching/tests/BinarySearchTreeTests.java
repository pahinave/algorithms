package pahinave.algorithms.searching.tests;

import java.util.Random;

import org.junit.Test;

import pahinave.algorithms.searching.BinarySearchTree;

public class BinarySearchTreeTests {
	@Test
	public void testInsert() throws Exception {
		System.out.println("TEST CASE : testInsert");
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			bst.insert(r.nextInt(100));
		}
		bst.printRecursive();
	}

	@Test
	public void testSearch() throws Exception {
		System.out.println("TEST CASE : testSearch");
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			bst.insert(r.nextInt(20));
		}
		bst.printRecursive();
		for (int i = 0; i < 20; i++) {
			Integer s = r.nextInt(20);
			System.out.println("Search " + s + " - Result: " + bst.search(s));
		}
	}
}
