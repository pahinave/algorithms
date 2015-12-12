package pahinave.algorithms.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiStack {
	List<LinkedList<Integer>> stacks;
	int threshold;

	public MultiStack(int threshold) {
		stacks = new ArrayList<>();
		this.threshold = threshold;
	}

	public void push(int data) {
		if (stacks.size() == 0 || stacks.get(stacks.size() - 1).size() == threshold) {
			stacks.add(new LinkedList<>());
		}
		LinkedList<Integer> latest = stacks.get(stacks.size() - 1);
		latest.push(data);
	}

	public int pop() {
		if (stacks.size() == 0) {
			return -1;
		} else {
			return pop(stacks.size() - 1);
		}
	}

	public int pop(int stackNo) {
		if (stackNo > (stacks.size() - 1) || stacks.get(stackNo).size() == 0) {
			return -1;
		}

		LinkedList<Integer> requiredStack = stacks.get(stackNo);
		int data = requiredStack.pop().intValue();
		if (requiredStack.size() == 0 && stacks.size() > 1) {
			stacks.remove(stackNo);
		}

		return data;
	}

}
