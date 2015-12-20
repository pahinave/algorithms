package pahinave.algorithms.problems.tests;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.Parenthesis;

public class ParenthesisTest {

	@Test
	public void testNParenthesisForN3() {
		Parenthesis p = new Parenthesis();
		Set<String> combinations = p.nParenthesis(3);
		System.out.println(combinations);
		Assert.assertEquals(5, combinations.size());
	}

	@Test
	public void testNParenthesisForN1() {
		Parenthesis p = new Parenthesis();
		Set<String> combinations = p.nParenthesis(1);
		System.out.println(combinations);
		Assert.assertEquals(1, combinations.size());
	}

	@Test
	public void testNParenthesisForN0() {
		Parenthesis p = new Parenthesis();
		Set<String> combinations = p.nParenthesis(0);
		System.out.println(combinations);
		Assert.assertEquals(0, combinations.size());
	}

}
