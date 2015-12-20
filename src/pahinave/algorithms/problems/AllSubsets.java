package pahinave.algorithms.problems;

import java.util.HashSet;
import java.util.Set;

public class AllSubsets {
	public Set<Set<String>> allSubsets(Set<String> set) {
		Set<Set<String>> subsets = new HashSet<>();

		for (String element : set) {
			Set<Set<String>> newAdditions = new HashSet<>();

			Set<String> newElementSet = new HashSet<>();
			newElementSet.add(element);
			newAdditions.add(newElementSet);
			for (Set<String> subset : subsets) {
				Set<String> newSubset = new HashSet<>(subset);
				newSubset.add(element);
				newAdditions.add(newSubset);
			}
			subsets.addAll(newAdditions);
		}
		
		// add empty subset
		subsets.add(new HashSet<>());
		return subsets;
	}
}
