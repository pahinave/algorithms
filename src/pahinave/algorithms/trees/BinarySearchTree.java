package pahinave.algorithms.trees;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
	Node root;

	public class Node implements Comparable<Node> {
		T data;
		Node left;
		Node right;
		Node parent;

		public Node(T data) {
			super();
			this.data = data;
		}

		public Node(Node value) {
			this.setValues(value);
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

		@Override
		public int compareTo(BinarySearchTree<T>.Node o) {
			return this.getData().compareTo(o.getData());
		}

		public void setValues(Node value) {
			this.data = value.getData();
			this.left = value.getLeft();
			this.right = value.getRight();
			this.parent = value.getParent();
		}

	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node insert(T value) {
		Node newNode = new Node(value);
		insert(newNode);
		return newNode;
	}

	public void insert(Node newNode) {
		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
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

	public Node search(T value) {

		Node current = root;
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

	public void printPreorder(Node node) {
		if (node == null)
			return;
		System.out.println(node);
		printPreorder(node.getLeft());
		printPreorder(node.getRight());
	}

	private void printRecursiveLoop(Node n, int level) {
		if (n.getLeft() != null) {
			printRecursiveLoop(n.getLeft(), level + 1);
		}

		System.out.println("Level" + level + ":" + n);

		if (n.getRight() != null) {
			printRecursiveLoop(n.getRight(), level + 1);
		}
	}

	public void collectInorder(List<Node> inorder) {
		collectInorder(inorder, this.getRoot());
	}

	public void collectInorder(List<Node> inorder, Node current) {
		if (current.getLeft() != null) {
			collectInorder(inorder, current.getLeft());
		}
		inorder.add(current);
		if (current.getRight() != null) {
			collectInorder(inorder, current.getRight());
		}
	}

	public Node maximum() {
		if (root == null) {
			return null;
		}

		return maximum(this.getRoot());
	}

	public Node maximum(Node node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}

		return node;
	}

	public Node minimum() {
		if (root == null) {
			return null;
		}

		return minimum(this.getRoot());
	}

	public Node minimum(Node node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}

		return node;
	}

	public Node predecessor(Node node) {

		Node current = node;

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

	public Node successor(Node node) {
		Node current = node;
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

	public void delete(Node node) {

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
			Node singleChild = (node.getLeft() == null) ? node.getRight() : node.getLeft();
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
		Node pred = predecessor(node);
		T temp = pred.getData();
		pred.setData(node.getData());
		node.setData(temp);
		delete(pred);

	}

}
