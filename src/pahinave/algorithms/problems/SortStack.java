package pahinave.algorithms.problems;

import java.util.LinkedList;

public class SortStack {
	public LinkedList<Integer> sort(LinkedList<Integer> source) {
		System.out.println(source);
		LinkedList<Integer> sorted = new LinkedList<Integer>();
		while(source.size() > 0) {
			int item = source.pop();
			while(sorted.size() > 0 && sorted.peek() < item) {
				source.push(sorted.pop());
			}
			sorted.push(item);
		}
		
		return sorted;
	}

}
