package pahinave.algorithms.problems;

import java.util.LinkedList;

public class TowerOfHonoi {

	public void solve(int nDisks) {
		TohRod source = new TohRod("A");
		TohRod destination = new TohRod("B");
		TohRod temp = new TohRod("C");

		for (int i = nDisks; i > 0; i--) {
			source.push(i);
		}

		toh(nDisks, source, destination, temp);
	}

	private void step(TohRod source, TohRod destination) {
		Integer sourceTop = source.peek();
		Integer destTop = destination.peek();
		System.out.println("Move " + sourceTop + " from " + source.getName() + " to " + destination.getName()
				+ " above " + destTop);
		source.pop();
		destination.push(sourceTop);
	}

	private void toh(int nDisks, TohRod source, TohRod destination, TohRod temp) {
		if (nDisks > 1) {
			toh(nDisks - 1, source, temp, destination);
		}
		step(source, destination);
		if (nDisks > 1) {
			toh(nDisks - 1, temp, destination, source);
		}
	}
}

@SuppressWarnings("serial")
class TohRod extends LinkedList<Integer> {
	String name;

	public TohRod(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
