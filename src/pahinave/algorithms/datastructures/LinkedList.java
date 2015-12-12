package pahinave.algorithms.datastructures;

// inserts new nodes in the front
public class LinkedList {
	public class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

	Node head;

	public LinkedList() {
	}

	public void reverse() {
		if (head == null || head.getNext() == null) {
			return; // no action item for empty or single item linked list
		}

		Node previous = head;
		Node current = head.getNext();
		head.setNext(null);
		while (current != null) {
			Node next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}

		// point head to last element
		head = previous;
	}

	public Node getHead() {
		return head;
	}

	public void insert(Node node) {
		if (head == null) {
			head = node;
		} else {
			node.setNext(head);
			head = node;
		}
	}
	public Node insert(int data) {
		Node node = new Node(data);
		this.insert(node);
		return node;
	}

	public void removeDuplicates() {
		Node previous = head;
		Node current = head.getNext();

		while (current != null) {
			Node ptr = head;
			while (ptr != current && ptr.getData() != current.getData()) {
				ptr = ptr.getNext();
			}

			if (ptr != current) {
				previous.next = current.next;
			} else {
				previous = previous.next;
			}
			current = current.next;
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node current = head;
		while (current != null) {
			sb.append(current.getData() + " ");
			current = current.getNext();
		}
		return sb.toString();
	}

	public int size() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public int remove() {
		if(head != null) {
			int data = head.getData();
			head = head.getNext();
			return data;
		}
		return -1;
	}

}
