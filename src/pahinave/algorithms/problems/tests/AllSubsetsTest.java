package pahinave.algorithms.problems.tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.AllSubsets;

public class AllSubsetsTest {
	@Test
	public void allSubsetsTest() throws Exception {
		Set<String> strings = new HashSet<>();
		strings.add("A");
		strings.add("B");
		strings.add("C");
		strings.add("D");
		strings.add("E");
		strings.add("F");
		
		AllSubsets as = new AllSubsets();
		Set<Set<String>> subsets = as.allSubsets(strings);
		Assert.assertEquals((int)Math.pow(2, strings.size()), subsets.size());
		
	}
}
