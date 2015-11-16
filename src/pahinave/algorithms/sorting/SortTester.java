package pahinave.algorithms.sorting;

import static pahinave.utilities.ArrayUtitilities.generateDecreasingArray;
import static pahinave.utilities.ArrayUtitilities.generateIncreasingArray;
import static pahinave.utilities.ArrayUtitilities.generateRandomArray;
import static pahinave.utilities.ArrayUtitilities.generateSameNumberArray;
import static pahinave.utilities.ArrayUtitilities.printArray;

public class SortTester {
	public static void main(String[] args) {

		// Test selection sort
		//test(new SelectionSort());
		
		// Test bubble sort
		//test(new BubbleSort());
		
		// Test insertion sort
		//test(new InsertionSort());
		
		// test merge sort
		//test(new MergeSort());
		
		// test quick sort
		// Using random pivot
		test(new QuickSort((start, end) -> (start + (int)(Math.random() * 10) % (end - start))));
		// Using first element as pivot always
		//test(new QuickSort());

	}

	private static void test(Sorter sorter) {
		// n elements
		int n = 20;
		
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
		
		System.out.println("\n*** Sort subarray 2 to 18 ***");
		testSortSubArray(generateRandomArray(n), sorter, 2, 18);
		testSortSubArray(generateDecreasingArray(n), sorter, 2, 18);
		testSortSubArray(generateIncreasingArray(n), sorter, 2, 18);

		
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
