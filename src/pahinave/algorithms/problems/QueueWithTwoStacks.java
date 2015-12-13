package pahinave.algorithms.problems;

import java.util.LinkedList;

public class QueueWithTwoStacks {
	LinkedList<Integer> current = new LinkedList<>();
	LinkedList<Integer> temp = new LinkedList<>();

	public void add(int data) {
		current.push(data);
	}

	public int remove() {
		if (current.size() == 0) {
			return -1;
		}

		int size = current.size();
		for (int i = 1; i < size; i++) {
			temp.push(current.pop());
		}
		int data = current.pop();
		
		LinkedList<Integer> t = temp;
		temp = current;
		current = t;
		
		return data;
	}
}
