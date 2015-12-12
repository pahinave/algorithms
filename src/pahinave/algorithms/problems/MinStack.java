package pahinave.algorithms.problems;

import pahinave.algorithms.datastructures.LinkedList;

public class MinStack extends LinkedList{
	class MinNode extends Node {
		Node min;
		public MinNode(int data) {
			super(data);
			min = this;
		}
		public Node getMin() {
			return min;
		}
		public void setMin(Node min) {
			this.min = min;
		}
		
		
	}
	
	public void push(int data) {
		MinNode node = new MinNode(data);
		if(this.getHead() != null) {
			MinNode top = (MinNode) this.getHead();
			if(data > top.getMin().getData()) {
				node.setMin(top.getMin());
			}
		}
		this.insert(node);
	}
	
	public int pop() {
		return super.remove();
	}
	
	public int min() {
		MinNode top = (MinNode) this.getHead();
		if(top != null) {
			return top.getMin().getData();
		}
		return -1;
	}

}
