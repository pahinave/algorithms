package pahinave.algorithms.problems;

import pahinave.algorithms.datastructures.LinkedList;
import pahinave.algorithms.datastructures.LinkedList.Node;

public class CorruptedLinkedList {
	public Node findCircularListStart(LinkedList list) {
		if ( list == null) {
			return null;
		}
		
		Node n1 = list.getHead();
		Node n2 = list.getHead();
		
		// loop till nodes point / list ends (meaning list is not circular)
		while(n2 != null && n2.getNext() != null) {
			n1 = n1.getNext();
			n2 = n2.getNext().getNext();
			if(n1 == n2) {
				break;
			}
		}
		
		// if fast n2 has reached end of list, its not a circular list
		if(n2 == null || n2.getNext() == null) {
			return null;
		}
		
		// n2 is k nodes before start of loop as well as k nodes from start
		// of loop
		n1 = list.getHead();
		while(n1 != n2) {
			n1 = n1.getNext();
			n2 = n2.getNext();
		}

		return n2;
	}
}
