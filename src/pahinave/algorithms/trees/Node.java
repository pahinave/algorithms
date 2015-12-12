package pahinave.algorithms.trees;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	T data;
	Node<T> left;
	Node<T> right;
	Node<T> parent;

	public Node(T data) {
		super();
		this.data = data;
	}

	public Node(Node<T> value) {
		this.setValues(value);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	@Override
	public int compareTo(Node<T> o) {
		return this.getData().compareTo(o.getData());
	}

	public void setValues(Node<T> value) {
		this.data = value.getData();
		this.left = value.getLeft();
		this.right = value.getRight();
		this.parent = value.getParent();
	}

}
