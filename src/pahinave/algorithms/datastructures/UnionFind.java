package pahinave.algorithms.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UnionFind<T> {
	Map<T, T> leaderMap;
	Map<T, List<T>> memberMap;

	public UnionFind() {
		super();
		leaderMap = new HashMap<>();
		memberMap = new HashMap<>();
	}

	public void addLeader(T leader) {
		leaderMap.put(leader, leader);
		List<T> members = new ArrayList<>();
		members.add(leader);
		memberMap.put(leader, members);
	}

	public void addMember(T member, T leader) {
		leaderMap.put(member, leader);
		memberMap.get(leader).add(member);
	}

	public T getLeader(T member) {
		return leaderMap.get(member);
	}

	public void setLeader(T member, T leader) {
		T prevLeader = leaderMap.get(member);
		memberMap.get(prevLeader).remove(member);
		memberMap.get(leader).add(member);
		leaderMap.put(member, leader);
	}

	public int getSizeOfContainingComponent(T member) {
		return memberMap.get(leaderMap.get(member)).size();
	}

	public boolean memberOfDiffComponents(T member1, T member2) {
		return getLeader(member1) != getLeader(member2);
	}

	public void union(T member1, T member2) {

		int size1 = this.getSizeOfContainingComponent(member1);
		int size2 = this.getSizeOfContainingComponent(member2);

		T smallComponentMember = null;
		T bigComponentMember = null;
		if (size1 < size2) {
			smallComponentMember = member1;
			bigComponentMember = member2;
		} else {
			smallComponentMember = member2;
			bigComponentMember = member1;
		}

		T leaderOfSmallComponent = this.getLeader(smallComponentMember);
		T newLeader = this.getLeader(bigComponentMember);

		List<T> bigComponentMembers = memberMap.get(newLeader);
		for (T member : this.getMembersOfContainingComponent(smallComponentMember)) {

			leaderMap.put(member, newLeader);
			bigComponentMembers.add(member);
		}

		memberMap.remove(leaderOfSmallComponent);

	}

	private List<T> getMembersOfContainingComponent(T member) {
		return memberMap.get(getLeader(member));
	}

	public void show() {
		System.out.println("State of union-find:");
		for (Entry<T, List<T>> mm : memberMap.entrySet()) {
			System.out.println(mm.getKey() + ":" + mm.getValue().size() + " => " + mm.getValue());
		}
	}
}
