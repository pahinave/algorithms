package pahinave.algorithms.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Intervals {

	public boolean isOverlappingInterval(Interval first, Interval second) {

		Interval lower = first;
		Interval higher = second;
		if (second.getLow() < first.getLow()) {
			lower = second;
			higher = first;
		}

		if (lower.getLow() <= higher.getLow() && higher.getLow() <= lower.getHigh()) {
			return true;
		}

		return false;
	}

	public Interval maxOverlappingSubInterval(List<Interval> intervals) {
		class IntervalNode implements Comparable<IntervalNode> {
			private boolean low;
			private int value;

			public IntervalNode(int value, boolean low) {
				super();
				this.value = value;
				this.low = low;
			}

			public int getValue() {
				return value;
			}

			public boolean isLow() {
				return low;
			}

			@Override
			public int compareTo(IntervalNode o) {
				int ret = 0;
				if (this.getValue() != o.getValue()) {
					ret = this.getValue() - o.getValue();
				} else if (this.isLow()) {
					ret = -1;
				} else if (o.isLow()) {
					ret = 1;
				}
				return ret;
			}

			@Override
			public String toString() {
				return "IntervalNode [low=" + low + ", value=" + value + "]";
			}

		}

		List<IntervalNode> nodes = new ArrayList<>();
		for (Interval i : intervals) {
			nodes.add(new IntervalNode(i.getLow(), true));
			nodes.add(new IntervalNode(i.getHigh(), false));
		}

		Collections.sort(nodes);

		int max_overlap = 0;
		int max_overlap_low = 0;
		int last_low = 0;
		int max_overlap_high = 0;
		int overlap_count = 0;
		for (IntervalNode node : nodes) {
			// System.out.println(node);
			if (node.isLow()) {
				overlap_count++;
				last_low = node.getValue();
			} else {
				if (overlap_count > max_overlap) {
					max_overlap_low = last_low;
					max_overlap_high = node.getValue();
					max_overlap = overlap_count;
				}
				overlap_count--;
			}
		}

		System.out.println("Max overlapping intervals:" + max_overlap + " max overlap " + max_overlap_low + " "
				+ max_overlap_high);

		return new Interval(max_overlap_low, max_overlap_high);
	}

}
