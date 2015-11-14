package pahinave.algorithms.sorting;

import static pahinave.algorithms.sorting.Common.generateDecreasingArray;
import static pahinave.algorithms.sorting.Common.generateIncreasingArray;
import static pahinave.algorithms.sorting.Common.generateRandomArray;
import static pahinave.algorithms.sorting.Common.printArray;

public class SortTester {
	public static void main(String[] args) {

		// Test selection sort
		//test(new SelectionSort());
		
		// Test bubble sort
		//test(new BubbleSort());
		
		// Test insertion sort
		test(new InsertionSort());

	}

	private static void test(Sorter sorter) {
		// n elements
		int n = 10;
		
		testAllAscending(n, sorter);
		
		testAllDescending(n, sorter);
		
		testRandom(n, sorter);
		
		//test empty array
		testRandom(0, sorter);
		//Test single element
		testRandom(1, sorter);
		//Test two element
		testRandom(2, sorter);
	}

	private static void testRandom(int n, Sorter sorter) {
		int[] numbers = generateRandomArray(n);
		printArray("Original random numbers", numbers);
		sorter.sort(numbers);
		printArray("Sorted random numbers", numbers);
	}

	private static void testAllDescending(int n, Sorter sorter) {
		int[] numbers = generateDecreasingArray(n);
		printArray("Original decreasing numbers", numbers);
		sorter.sort(numbers);
		printArray("Sorted decreasing numbers", numbers);
	}

	private static void testAllAscending(int n, Sorter sorter) {
		int[] numbers = generateIncreasingArray(n);
		printArray("Original acending numbers", numbers);
		sorter.sort(numbers);
		printArray("Sorted acending numbers", numbers);
	}
}
