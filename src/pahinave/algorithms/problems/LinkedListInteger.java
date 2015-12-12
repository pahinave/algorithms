package pahinave.algorithms.problems;

import pahinave.algorithms.datastructures.LinkedList;

public class LinkedListInteger extends LinkedList {

	public LinkedListInteger() {
		super();
	}

	public LinkedListInteger(int number) {
		while (number != 0) {
			insert(number % 10);
			number = number / 10;
		}
		reverse();
	}

	public int toNumber() {
		int number = 0;
		int multiplier = 1;
		Node current = this.getHead();

		while (current != null) {
			number = number + current.getData() * multiplier;
			multiplier *= 10;
			current = current.getNext();
		}

		return number;
	}

}
