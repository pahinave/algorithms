package pahinave.algorithms.problems.tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import pahinave.algorithms.problems.LinkedListInteger;
import pahinave.algorithms.problems.LinkedLists;

public class LinkedListsTest {
	@Test
	public void testSumSameLengthNoCarry() throws Exception {
		LinkedLists ls = new LinkedLists();
		int firstNumber = 1234;
		int secondNumber = 2345;
		LinkedListInteger first = new LinkedListInteger(firstNumber);
		LinkedListInteger second = new LinkedListInteger(secondNumber);
		LinkedListInteger result = ls.sum(first, second);
		assertEquals((firstNumber + secondNumber), result.toNumber());
	}

	@Test
	public void testSumSameLengthWithCarry() throws Exception {
		LinkedLists ls = new LinkedLists();
		int firstNumber = 1239;
		int secondNumber = 2345;
		LinkedListInteger first = new LinkedListInteger(firstNumber);
		LinkedListInteger second = new LinkedListInteger(secondNumber);
		LinkedListInteger result = ls.sum(first, second);
		assertEquals((firstNumber + secondNumber), result.toNumber());
	}

	@Test
	public void testDiffLengthFirstLonger() throws Exception {
		LinkedLists ls = new LinkedLists();
		int firstNumber = 12369;
		int secondNumber = 2345;
		LinkedListInteger first = new LinkedListInteger(firstNumber);
		LinkedListInteger second = new LinkedListInteger(secondNumber);
		LinkedListInteger result = ls.sum(first, second);
		assertEquals((firstNumber + secondNumber), result.toNumber());
	}

	@Test
	public void testDiffLengthSecondLonger() throws Exception {
		LinkedLists ls = new LinkedLists();
		int firstNumber = 1234;
		int secondNumber = 23478;
		LinkedListInteger first = new LinkedListInteger(firstNumber);
		LinkedListInteger second = new LinkedListInteger(secondNumber);
		LinkedListInteger result = ls.sum(first, second);
		assertEquals((firstNumber + secondNumber), result.toNumber());
	}

	@Test
	public void testRandomNumberSumsFor1000Times() throws Exception {
		Random r = new Random();
		LinkedLists ls = new LinkedLists();
		for (int i = 0; i < 1000; i++) {
			int firstNumber = r.nextInt(9999999);
			int secondNumber = r.nextInt(9999999);
			LinkedListInteger first = new LinkedListInteger(firstNumber);
			LinkedListInteger second = new LinkedListInteger(secondNumber);
			LinkedListInteger result = ls.sum(first, second);
			assertEquals((firstNumber + secondNumber), result.toNumber());
		}
	}
}
