package pahinave.algorithms.sorting;

import static pahinave.algorithms.sorting.Common.*;

public class SortTester {
	public static void main(String[] args) {

		// Test selection sort
		test(new SelectionSort());
		
		// Test bubble sort
		//test(new BubbleSort());
		
		// Test insertion sort
		//test(new InsertionSort());

	}

	private static void test(Sorter sorter) {
		// n elements
		int n = 10;
		
		test(generateSameNumberArray(n), sorter);
		test(generateRandomArray(n), sorter);
		test(generateDecreasingArray(n), sorter);
		test(generateIncreasingArray(n), sorter);
		
		// no element array
		test(new int[0], sorter);
		
		// single element array
		test(new int[]{123}, sorter);
		
		// 2 element array
		test(new int[]{34,12}, sorter);
		
		System.out.println("\n*** Sort subarray 2 to 8 ***");
		testSortSubArray(generateRandomArray(n), sorter, 2, 8);
		testSortSubArray(generateDecreasingArray(n), sorter, 2, 8);
		testSortSubArray(generateIncreasingArray(n), sorter, 2, 8);

		
	}

	private static void test(int[] numbers, Sorter sorter) {
		printArray("Original numbers", numbers);
		sorter.sort(numbers);
		printArray("Sorted numbers", numbers);
	}
	
	private static void testSortSubArray(int[] numbers, Sorter sorter, int start, int end) {
		printArray("Original numbers", numbers);
		sorter.sort(numbers, start, end);
		printArray("Sorted numbers", numbers);
	}
}
