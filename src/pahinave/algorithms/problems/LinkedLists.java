package pahinave.algorithms.problems;

import pahinave.algorithms.datastructures.LinkedList.Node;

public class LinkedLists {
	public LinkedListInteger sum(LinkedListInteger first, LinkedListInteger second) {
		if (first == null || second == null) {
			return first == null ? second : first;
		}

		int carry = 0;
		LinkedListInteger result = new LinkedListInteger();

		Node f = first.getHead();
		Node s = second.getHead();
		// add common place elements
		while (f != null && s != null) {
			int value = carry + f.getData() + s.getData();
			result.insert(value % 10);
			carry = value / 10;
			f = f.getNext();
			s = s.getNext();
		}

		// add digits from longer number, if any
		Node remaining = (f == null ? s : f);
		while (remaining != null) {
			int value = carry + remaining.getData();
			result.insert(value % 10);
			carry = value / 10;
			remaining = remaining.getNext();
		}

		// add digit for final carry, if not zero
		if (carry != 0) {
			result.insert(carry);
		}

		result.reverse();

		return result;
	}
}
