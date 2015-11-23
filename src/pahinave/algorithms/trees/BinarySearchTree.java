package pahinave.algorithms.trees;

public class BinarySearchTree<T extends Comparable<T>> {
	Node root;

	public class Node {
		T data;
		Node left;
		Node right;

		public Node(T data) {
			super();
			this.data = data;
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

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

	public void insert(T value) {
		insert(new Node(value));
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
					break;
				} else {
					current = current.getLeft();
				}
			} else {
				if (current.getRight() == null) {
					current.setRight(newNode);
					break;
				} else {
					current = current.getRight();
				}
			}
		}
	}
	
	public Node search(T value) {
		
		Node current = root;
		while(true) {
			if(current == null || current.getData().compareTo(value) == 0) {
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
		if(root != null) {
			System.out.println("debug printing recursive");
			printRecursiveLoop(root, 0);
		} else {
			System.out.println("Tree is empty");
		}
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

}
