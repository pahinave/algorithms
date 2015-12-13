package pahinave.algorithms.trees.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pahinave.algorithms.trees.BinarySearchTree;
import pahinave.algorithms.trees.Node;

public class BinarySearchTreeTests {

	BinarySearchTree<Integer> bst;
	int range = 100;
	int nNodes = 11;

	@Before
	public void initialize() {
		Random r = new Random();

		bst = new BinarySearchTree<>();

		// tree assumes root node is 50
		// so that random numbers will be distributed
		// in both left and right tree
		bst.insert(50);
		for (int i = 0; i < nNodes - 1; i++) {
			// all random numbers will be > 0
			int n = r.nextInt(range) + 1;
			bst.insert(n);
		}
	}

	@Test
	public void testInsert() throws Exception {
		System.out.println("TEST CASE : testInsert");

		bst.printRecursive();
	}

	@Test
	public void testSearch() throws Exception {
		System.out.println("TEST CASE : testSearch");
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			Integer s = r.nextInt(range);
			System.out.println("Search " + s + " - Result: " + bst.search(s));
		}
	}

	@Test
	public void testCollectInorder() throws Exception {
		System.out.println("TEST CASE : testCollectInorder");

		List<Node<Integer>> inorder = new ArrayList<>();
		bst.collectInorder(inorder, bst.getRoot());
		assertEquals(nNodes, inorder.size());
		for (int i = 0; i < nNodes - 1; i++) {
			assertNotEquals(1, inorder.get(i).compareTo(inorder.get(i + 1)));
		}

	}

	@Test
	public void testPredecessor() throws Exception {
		System.out.println(">>>>>>>>> TEST CASE : testPredecessor");

		List<Node<Integer>> inorder = new ArrayList<>();
		bst.collectInorder(inorder, bst.getRoot());

		assertEquals("predecessor of min node is not null", null, bst.predecessor(inorder.get(0)));
		for (int i = 1; i < inorder.size(); i++) {
			assertEquals("predecessor is wrong", inorder.get(i - 1), bst.predecessor(inorder.get(i)));
		}
	}

	@Test
	public void testFindMax() throws Exception {
		// insert max number
		int max = range + 1;
		bst.insert(max);
		Node<Integer> foundMax = bst.maximum();
		assertEquals(Integer.valueOf(max), foundMax.getData());
	}

	@Test
	public void findMinium() throws Exception {
		// insert min number
		int min = 0;
		bst.insert(min);
		Node<Integer> foundMin = bst.minimum();
		assertEquals(Integer.valueOf(min), foundMin.getData());
	}

	@Test
	public void findMinimumInEmptyTree() throws Exception {
		assertEquals(null, new BinarySearchTree<Integer>().minimum());
	}

	@Test
	public void findMaximumInEmptyTree() throws Exception {
		assertEquals(null, new BinarySearchTree<Integer>().maximum());
	}

	@Test
	public void testSuccessor() throws Exception {
		List<Node<Integer>> inorder = new ArrayList<>();
		bst.collectInorder(inorder, bst.getRoot());

		for (int i = 0; i < inorder.size() - 1; i++) {
			assertEquals(inorder.get(i + 1), bst.successor(inorder.get(i)));
		}
		assertEquals(null, bst.successor(inorder.get(inorder.size() - 1)));

	}

	@Test
	public void testDeleteSimple() throws Exception {
		bst = new BinarySearchTree<>();

		Node<Integer> node5 = bst.insert(5);
		Node<Integer> node3 = bst.insert(3);
		Node<Integer> node6 = bst.insert(6);
		Node<Integer> node4 = bst.insert(4);

		bst.delete(node4);
		List<Node<Integer>> nodes = new ArrayList<>();
		bst.collectInorder(nodes);
		assertEquals(3, nodes.size());
		assertEquals(node3, nodes.get(0));
		assertEquals(node5, nodes.get(1));
		assertEquals(node6, nodes.get(2));

	}

	@Test
	public void testDeleteSingleChild1() throws Exception {

		// single child is right of parent
		bst = new BinarySearchTree<>();

		Node<Integer> node5 = bst.insert(5);
		Node<Integer> node3 = bst.insert(3);
		Node<Integer> node6 = bst.insert(6);
		Node<Integer> node4 = bst.insert(4);
		Node<Integer> node1 = bst.insert(1);
		Node<Integer> node2 = bst.insert(2);

		bst.delete(node2);
		List<Node<Integer>> nodes = new ArrayList<>();
		bst.collectInorder(nodes);
		assertEquals(5, nodes.size());
		assertEquals(node1, nodes.get(0));
		assertEquals(node3, nodes.get(1));
		assertEquals(node4, nodes.get(2));
		assertEquals(node5, nodes.get(3));
		assertEquals(node6, nodes.get(4));
	}

	@Test
	public void testDeleteSingleChild2() throws Exception {

		// single child is left of parent
		bst = new BinarySearchTree<>();

		Node<Integer> node5 = bst.insert(5);
		Node<Integer> node3 = bst.insert(3);
		Node<Integer> node6 = bst.insert(6);
		Node<Integer> node4 = bst.insert(4);
		Node<Integer> node2 = bst.insert(2);
		Node<Integer> node1 = bst.insert(1);

		bst.delete(node2);
		List<Node<Integer>> nodes = new ArrayList<>();
		bst.collectInorder(nodes);
		assertEquals(5, nodes.size());
		assertEquals(node1, nodes.get(0));
		assertEquals(node3, nodes.get(1));
		assertEquals(node4, nodes.get(2));
		assertEquals(node5, nodes.get(3));
		assertEquals(node6, nodes.get(4));
	}

	@Test
	public void testNodeWithTwoChilds() throws Exception {
		// single child is left of parent
		bst = new BinarySearchTree<>();

		// 5
		// x3 6
		// 2 4
		// 1
		// 0
		bst.insert(5);
		Node<Integer> nodeToDelete = bst.insert(3);
		bst.insert(6);
		bst.insert(4);
		bst.insert(2);
		bst.insert(1);
		bst.insert(0);

		bst.delete(nodeToDelete);
		List<Node<Integer>> nodes = new ArrayList<>();
		bst.collectInorder(nodes);
		assertEquals(6, nodes.size());
		assertEquals(Integer.valueOf(0), nodes.get(0).getData());
		assertEquals(Integer.valueOf(1), nodes.get(1).getData());
		assertEquals(Integer.valueOf(2), nodes.get(2).getData());
		assertEquals(Integer.valueOf(4), nodes.get(3).getData());
		assertEquals(Integer.valueOf(5), nodes.get(4).getData());
		assertEquals(Integer.valueOf(6), nodes.get(5).getData());

	}

	@Test
	public void testBalancedTrue() throws Exception {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		List<Integer> values = Arrays.asList(4, 2, 6, 1, 3, 5, 6, 7);
		tree.insertAll(values);

		boolean isBalanced = tree.isBalanced();
		assertEquals(true, isBalanced);
	}

	@Test
	public void testBalancedTrue2() throws Exception {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		List<Integer> values = Arrays.asList(4, 2, 6, 1, 7);
		tree.insertAll(values);

		boolean isBalanced = tree.isBalanced();
		assertEquals(true, isBalanced);

	}

	@Test
	public void testUnbalanced() throws Exception {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		List<Integer> values = Arrays.asList(4, 1, 6, 3, 5, 7, 2);
		tree.insertAll(values);

		boolean isBalanced = tree.isBalanced();
		assertEquals(false, isBalanced);
	}

	@Test
	public void testBuildBinarySearchTreeFromSortedArrayOddLength() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.buildFromSortedList(numbers);
		Assert.assertTrue(bst.isBalanced());
		Assert.assertEquals(4, bst.depth());
	}

	@Test
	public void testBuildBinarySearchTreeFromSortedArrayEvenLength() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.buildFromSortedList(numbers);
		Assert.assertTrue(bst.isBalanced());
		Assert.assertEquals(4, bst.depth());
	}

}
