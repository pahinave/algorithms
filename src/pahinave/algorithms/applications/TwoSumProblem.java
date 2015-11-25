package pahinave.algorithms.applications;

import java.util.Hashtable;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class TwoSumProblem {
	public void findTwoSumPairs(int[] numbers, int sum) {
		Hashtable<Integer, Object> numberMap = new Hashtable<>();
		Object value = new Object();
		for(int number : numbers) {
			numberMap.put(number, value);
		}
		
		for(int number : numbers) {
			if(numberMap.containsKey(sum-number)) {
				System.out.println(number + " " + (sum-number));
			}
		}
	}
	
	public int[] genNumbers(int count) {
		Random r = new Random();
		return IntStream.generate(() -> r.nextInt(count * 2)).limit(count).toArray();
	}
	
	@Test
	public void testName() throws Exception {
		int numbers[] = genNumbers(1000000);
		TwoSumProblem o = new TwoSumProblem();
		o.findTwoSumPairs(numbers, 150);
		
	}
}
