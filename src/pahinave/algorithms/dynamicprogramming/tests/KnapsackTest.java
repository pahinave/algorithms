package pahinave.algorithms.dynamicprogramming.tests;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.dynamicprogramming.KnapSack;

public class KnapsackTest {
	@Test
	public void test1() throws Exception {
		KnapSack ks = new KnapSack();
		int n = 10;
		int[] values = new int[n];
		int[] weights = new int[n];
		int maxWeight = 0;
		Random r = new Random(System.currentTimeMillis());

		for (int i = 0; i < n; i++) {
			values[i] = r.nextInt(100);
			weights[i] = r.nextInt(100);
			if (weights[i] > maxWeight) {
				maxWeight = weights[i];
			}
		}

		int capacity = n * maxWeight;
		int actualCapacity = ks.solve(values, weights, capacity);
		System.out.println("max capacity: " + capacity);
		System.out.println("actual value:" + actualCapacity);
	}

	@Test
	public void test2() throws Exception {
		KnapSack ks = new KnapSack();
		int n = 6;
		int[] values = new int[n+1];
		int[] weights = new int[n+1];
		values[1] = 874;
		values[2] = 620;
		values[3] = 345;
		values[4] = 369;
		values[5] = 360;
		values[6] = 470;

		weights[1] = 580;
		weights[2] = 1616;
		weights[3] = 1906;
		weights[4] = 1942;
		weights[5] = 50;
		weights[6] = 294;
		
		int actualValue = ks.solve(values, weights, 2000);
		System.out.println("actual value: " + actualValue);
		Assert.assertEquals(1704, actualValue);

	}
}
