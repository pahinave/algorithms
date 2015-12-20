package pahinave.algorithms.problems;

import java.util.HashSet;
import java.util.Set;

public class Parenthesis {
	public Set<String> nParenthesis(int n) {
		Set<String> combinations = new HashSet<>();

		if (n == 0) {
			return combinations;
		}

		// base case - n=1
		combinations.add("()");

		// for n > 1
		for (int i = 2; i <= n; i++) {
			Set<String> nextCombinations = new HashSet<>();
			for (String combination : combinations) {
				nextCombinations.add("()" + combination);
				nextCombinations.add("(" + combination + ")");
				nextCombinations.add(combination + "()");
			}
			combinations = nextCombinations;
		}

		return combinations;
	}
}
