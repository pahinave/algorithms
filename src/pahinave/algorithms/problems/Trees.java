package pahinave.algorithms.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pahinave.algorithms.trees.BinarySearchTree;
import pahinave.algorithms.trees.Node;

public class Trees {

	public <T extends Comparable<T>> List<Node<T>> inorderUsingStack(BinarySearchTree<T> bst) {
		if (bst == null || bst.getRoot() == null) {
			return null;
		}
		LinkedList<Node<T>> stack = new LinkedList<>();
		List<Node<T>> inorder = new ArrayList<>();
		Node<T> current = bst.getRoot();
		while (true) {
			while (current != null) {
				stack.push(current);
				current = current.getLeft();
			}
			if (stack.size() > 0) {
				Node<T> top = stack.pop();
				inorder.add(top);
				current = top.getRight();
			} else {
				break;
			}
		}

		return inorder;

	}

	public <T extends Comparable<T>> List<Node<T>> preorderUsingStack(BinarySearchTree<T> bst) {
		if (bst == null || bst.getRoot() == null) {
			return null;
		}

		List<Node<T>> preorder = new ArrayList<>();
		LinkedList<Node<T>> stack = new LinkedList<>();
		Node<T> current = bst.getRoot();
		while (true) {
			while (current != null) {
				preorder.add(current);
				if (current.getRight() != null) {
					stack.push(current.getRight());
				}
				current = current.getLeft();
			}
			
			if(stack.size() > 0) {
				current = stack.pop();
			} else {
				break;
			}
		}

		return preorder;
	}

}
