package pahinave.algorithms.trees;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
	Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public Node<T> insert(T value) {
		Node<T> newNode = new Node<T>(value);
		insert(newNode);
		return newNode;
	}

	public void insert(Node<T> newNode) {
		if (root == null) {
			root = newNode;
			return;
		}

		Node<T> current = root;
		while (true) {
			if (newNode.getData().compareTo(current.getData()) <= 0) {
				if (current.getLeft() == null) {
					current.setLeft(newNode);
					newNode.setParent(current);
					break;
				} else {
					current = current.getLeft();
				}
			} else {
				if (current.getRight() == null) {
					current.setRight(newNode);
					newNode.setParent(current);
					break;
				} else {
					current = current.getRight();
				}
			}
		}
	}

	public Node<T> search(T value) {

		Node<T> current = root;
		while (true) {
			if (current == null || current.getData().compareTo(value) == 0) {
				return current;
			}

			if (value.compareTo(current.getData()) < 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
	}

	public void printRecursive() {
		if (root != null) {
			System.out.println("debug printing recursive");
			printRecursiveLoop(root, 0);
		} else {
			System.out.println("Tree is empty");
		}
	}

	public void printPreorder(Node<T> node) {
		if (node == null)
			return;
		System.out.println(node);
		printPreorder(node.getLeft());
		printPreorder(node.getRight());
	}

	private void printRecursiveLoop(Node<T> n, int level) {
		if (n.getLeft() != null) {
			printRecursiveLoop(n.getLeft(), level + 1);
		}

		System.out.println("Level" + level + ":" + n);

		if (n.getRight() != null) {
			printRecursiveLoop(n.getRight(), level + 1);
		}
	}

	public void collectInorder(List<Node<T>> inorder) {
		collectInorder(inorder, this.getRoot());
	}

	public void collectInorder(List<Node<T>> inorder, Node<T> current) {
		if (current.getLeft() != null) {
			collectInorder(inorder, current.getLeft());
		}
		inorder.add(current);
		if (current.getRight() != null) {
			collectInorder(inorder, current.getRight());
		}
	}

	public Node<T> maximum() {
		if (root == null) {
			return null;
		}

		return maximum(this.getRoot());
	}

	public Node<T> maximum(Node<T> node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}

		return node;
	}

	public Node<T> minimum() {
		if (root == null) {
			return null;
		}

		return minimum(this.getRoot());
	}

	public Node<T> minimum(Node<T> node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}

		return node;
	}

	public Node<T> predecessor(Node<T> node) {

		Node<T> current = node;

		if (current.getLeft() != null) {
			return maximum(current.getLeft());
		} else {

			while (current.getParent() != null && current.getParent().getLeft() == current) {
				current = current.getParent();
			}

			if (current == root) {
				return null;
			}

			return current.getParent();
		}

	}

	public Node<T> successor(Node<T> node) {
		Node<T> current = node;
		if (current.getRight() != null) {
			return minimum(current.getRight());
		} else {
			while (current.getParent() != null && current.getParent().getRight() == current) {
				current = current.getParent();
			}

			if (current == root) {
				return null;
			}

			return current.getParent();
		}
	}

	public void delete(Node<T> node) {

		// simple case - node without any child
		if (node.getLeft() == null && node.getRight() == null) {
			if (node == root) {
				root = null;
			} else if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(null);
			} else {
				node.getParent().setRight(null);
			}
			return;
		}

		// node with single child
		if (node.getLeft() == null || node.getRight() == null) {
			Node<T> singleChild = (node.getLeft() == null) ? node.getRight() : node.getLeft();
			if (node == root) {
				root = singleChild;
			} else if (node.getParent().getLeft() == node) {
				node.getParent().setLeft(singleChild);
			} else {
				node.getParent().setRight(singleChild);
			}
			return;
		}

		// node with two childs
		Node<T> pred = predecessor(node);
		T temp = pred.getData();
		pred.setData(node.getData());
		node.setData(temp);
		delete(pred);

	}
	
	

}
