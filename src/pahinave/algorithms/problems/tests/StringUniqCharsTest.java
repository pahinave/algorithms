package pahinave.algorithms.problems.tests;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.problems.StringUniqChars;

public class StringUniqCharsTest {
	@Test
	public void test1() {
		StringUniqChars solution = new StringUniqChars();
		char[] actual = solution.uniqChars(null);
		Assert.assertNull(actual);
	}

	@Test
	public void test2() {
		StringUniqChars solution = new StringUniqChars();
		char[] actual = solution.uniqChars(new char[] { 'a', 'b', 'c', 'd' });
		Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd' }, actual);
	}

	@Test
	public void test3() {
		StringUniqChars solution = new StringUniqChars();
		char[] actual = solution.uniqChars(
				new char[] { 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd' });
		Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd' }, actual);
	}

	@Test
	public void test4() {
		StringUniqChars solution = new StringUniqChars();
		char[] actual = solution.uniqChars(
				new char[] { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' });
		Assert.assertArrayEquals(new char[] { 'a' }, actual);
	}

	@Test
	public void test5() {
		StringUniqChars solution = new StringUniqChars();
		char[] actual = solution.uniqChars(new char[] { 'a' });
		Assert.assertArrayEquals(new char[] { 'a' }, actual);
	}
}
