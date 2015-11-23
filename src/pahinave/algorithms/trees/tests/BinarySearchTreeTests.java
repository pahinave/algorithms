package pahinave.algorithms.trees.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import pahinave.algorithms.trees.BinarySearchTree;

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

		List<BinarySearchTree<Integer>.Node> inorder = new ArrayList<>();
		bst.collectInorder(inorder, bst.getRoot());
		assertEquals(nNodes, inorder.size());
		for (int i = 0; i < nNodes - 1; i++) {
			assertNotEquals(1, inorder.get(i).compareTo(inorder.get(i + 1)));
		}

	}

	@Test
	public void testPredecessor() throws Exception {
		System.out.println(">>>>>>>>> TEST CASE : testPredecessor");

		List<BinarySearchTree<Integer>.Node> inorder = new ArrayList<>();
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
		BinarySearchTree<Integer>.Node foundMax = bst.maximum();
		assertEquals(Integer.valueOf(max), foundMax.getData());
	}

	@Test
	public void findMinium() throws Exception {
		// insert min number
		int min = 0;
		bst.insert(min);
		BinarySearchTree<Integer>.Node foundMin = bst.minimum();
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
		List<BinarySearchTree<Integer>.Node> inorder = new ArrayList<>();
		bst.collectInorder(inorder, bst.getRoot());

		for (int i = 0; i < inorder.size() - 1; i++) {
			assertEquals(inorder.get(i + 1), bst.successor(inorder.get(i)));
		}
		assertEquals(null, bst.successor(inorder.get(inorder.size() - 1)));

	}

	@Test
	public void testDeleteSimple() throws Exception {
		bst = new BinarySearchTree<>();

		BinarySearchTree<Integer>.Node node5 = bst.insert(5);
		BinarySearchTree<Integer>.Node node3 = bst.insert(3);
		BinarySearchTree<Integer>.Node node6 = bst.insert(6);
		BinarySearchTree<Integer>.Node node4 = bst.insert(4);

		bst.delete(node4);
		List<BinarySearchTree<Integer>.Node> nodes = new ArrayList<>();
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

		BinarySearchTree<Integer>.Node node5 = bst.insert(5);
		BinarySearchTree<Integer>.Node node3 = bst.insert(3);
		BinarySearchTree<Integer>.Node node6 = bst.insert(6);
		BinarySearchTree<Integer>.Node node4 = bst.insert(4);
		BinarySearchTree<Integer>.Node node1 = bst.insert(1);
		BinarySearchTree<Integer>.Node node2 = bst.insert(2);

		bst.delete(node2);
		List<BinarySearchTree<Integer>.Node> nodes = new ArrayList<>();
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

		BinarySearchTree<Integer>.Node node5 = bst.insert(5);
		BinarySearchTree<Integer>.Node node3 = bst.insert(3);
		BinarySearchTree<Integer>.Node node6 = bst.insert(6);
		BinarySearchTree<Integer>.Node node4 = bst.insert(4);
		BinarySearchTree<Integer>.Node node2 = bst.insert(2);
		BinarySearchTree<Integer>.Node node1 = bst.insert(1);

		bst.delete(node2);
		List<BinarySearchTree<Integer>.Node> nodes = new ArrayList<>();
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
		BinarySearchTree<Integer>.Node nodeToDelete = bst.insert(3);
		bst.insert(6);
		bst.insert(4);
		bst.insert(2);
		bst.insert(1);
		bst.insert(0);

		bst.delete(nodeToDelete);
		List<BinarySearchTree<Integer>.Node> nodes = new ArrayList<>();
		bst.collectInorder(nodes);
		assertEquals(6, nodes.size());
		assertEquals(Integer.valueOf(0), nodes.get(0).getData());
		assertEquals(Integer.valueOf(1), nodes.get(1).getData());
		assertEquals(Integer.valueOf(2), nodes.get(2).getData());
		assertEquals(Integer.valueOf(4), nodes.get(3).getData());
		assertEquals(Integer.valueOf(5), nodes.get(4).getData());
		assertEquals(Integer.valueOf(6), nodes.get(5).getData());

	}

}
