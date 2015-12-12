package pahinave.algorithms.trees.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import pahinave.algorithms.problems.Trees;
import pahinave.algorithms.trees.BinarySearchTree;
import pahinave.algorithms.trees.Node;

public class TreesTest {
	@Test
	public void testPreorderUsingStack() throws Exception {
		System.out.println("testPreorderUsingStack");
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(19);
		bst.insert(12);
		bst.insert(26);
		bst.insert(3);
		bst.insert(14);
		bst.insert(37);
		bst.insert(5);
		
		Trees t = new Trees();
		List<Node<Integer>> preorder = t.preorderUsingStack(bst);
		for(Node<Integer> node : preorder) {
			System.out.println(node);
		}
		
		assertEquals(7, preorder.size());
		assertEquals(Integer.valueOf(19), preorder.get(0).getData());
		assertEquals(Integer.valueOf(12), preorder.get(1).getData());
		assertEquals(Integer.valueOf(3), preorder.get(2).getData());
		assertEquals(Integer.valueOf(5), preorder.get(3).getData());
		assertEquals(Integer.valueOf(14), preorder.get(4).getData());
		assertEquals(Integer.valueOf(26), preorder.get(5).getData());
		assertEquals(Integer.valueOf(37), preorder.get(6).getData());
		
		
		
	}
	
	@Test
	public void testInorderUsingStack() throws Exception {
		System.out.println("testInorderUsingStack");
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(19);
		bst.insert(12);
		bst.insert(26);
		bst.insert(3);
		bst.insert(14);
		bst.insert(37);
		bst.insert(5);
		
		Trees t = new Trees();
		List<Node<Integer>> inorder = t.inorderUsingStack(bst);
		for(Node<Integer> n : inorder) {
			System.out.println(n);
		}
		assertEquals(7, inorder.size());
		assertEquals(Integer.valueOf(3), inorder.get(0).getData());
		assertEquals(Integer.valueOf(5), inorder.get(1).getData());
		assertEquals(Integer.valueOf(12), inorder.get(2).getData());
		assertEquals(Integer.valueOf(14), inorder.get(3).getData());
		assertEquals(Integer.valueOf(19), inorder.get(4).getData());
		assertEquals(Integer.valueOf(26), inorder.get(5).getData());
		assertEquals(Integer.valueOf(37), inorder.get(6).getData());
		
	}
	
	@Test
	public void testInorderUsingStackOnlyLeftNodes() throws Exception {
		System.out.println("testInorderUsingStackOnlyLeftNodes");
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(9);
		bst.insert(8);
		bst.insert(7);
		bst.insert(6);
		bst.insert(5);
		bst.insert(4);
		bst.insert(3);
		
		Trees t = new Trees();
		List<Node<Integer>> inorder = t.inorderUsingStack(bst);
		for(Node<Integer> n : inorder) {
			System.out.println(n);
		}
		assertEquals(8, inorder.size());
		assertEquals(Integer.valueOf(3), inorder.get(0).getData());
		assertEquals(Integer.valueOf(4), inorder.get(1).getData());
		assertEquals(Integer.valueOf(5), inorder.get(2).getData());
		assertEquals(Integer.valueOf(6), inorder.get(3).getData());
		assertEquals(Integer.valueOf(7), inorder.get(4).getData());
		assertEquals(Integer.valueOf(8), inorder.get(5).getData());
		assertEquals(Integer.valueOf(9), inorder.get(6).getData());
		assertEquals(Integer.valueOf(10), inorder.get(7).getData());
		
	}
	
	@Test
	public void testInorderUsingStackOnlyRightNodes() throws Exception {
		System.out.println("testInorderUsingStackOnlyRightNodes");
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(6);
		bst.insert(7);
		bst.insert(8);
		bst.insert(9);
		bst.insert(10);
		
		
		Trees t = new Trees();
		List<Node<Integer>> inorder = t.inorderUsingStack(bst);
		for(Node<Integer> n : inorder) {
			System.out.println(n);
		}
		assertEquals(8, inorder.size());
		assertEquals(Integer.valueOf(3), inorder.get(0).getData());
		assertEquals(Integer.valueOf(4), inorder.get(1).getData());
		assertEquals(Integer.valueOf(5), inorder.get(2).getData());
		assertEquals(Integer.valueOf(6), inorder.get(3).getData());
		assertEquals(Integer.valueOf(7), inorder.get(4).getData());
		assertEquals(Integer.valueOf(8), inorder.get(5).getData());
		assertEquals(Integer.valueOf(9), inorder.get(6).getData());
		assertEquals(Integer.valueOf(10), inorder.get(7).getData());
		
	}
	
	@Test
	public void testInorderUsingStackOnlyWithRandomNumbers() throws Exception {
		System.out.println("testInorderUsingStackOnlyWithRandomNumbers");
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		int nmax = 20;
		Random r = new Random();
		for(int i=0; i<nmax; i++) {
			bst.insert(r.nextInt(100));
		}
		
		Trees t = new Trees();
		List<Node<Integer>> inorder = t.inorderUsingStack(bst);
		for(Node<Integer> n : inorder) {
			System.out.println(n);
		}
		assertEquals(nmax, inorder.size());
		for(int i=0; i<nmax-1; i++) {
			assertTrue(inorder.get(i).getData() <= inorder.get(i+1).getData());
		}
	}
}

