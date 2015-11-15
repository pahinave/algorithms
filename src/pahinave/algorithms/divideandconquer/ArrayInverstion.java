package pahinave.algorithms.divideandconquer;

import static pahinave.utilities.ArrayUtitilities.generateDecreasingArray;
import static pahinave.utilities.ArrayUtitilities.generateDistinctRandomArray;
import static pahinave.utilities.ArrayUtitilities.generateIncreasingArray;


public class ArrayInverstion {
	public long bruteForce(int[] numbers) {
		long count = 0;
		
		for(int i=0; i < numbers.length - 1; i++) {
			for(int j=i+1; j < numbers.length; j++) {
				if(numbers[i] > numbers[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public long countInversion(int numbers[]) {
		return countInversion(numbers, 0, numbers.length-1);

	}
	public  long countInversion(int[] numbers, int left, int right) {

		if(left == right) return 0;
		int mid = (left + right) / 2;
		long leftInversion = countInversion(numbers, left, mid);
		long rightInverstion = countInversion(numbers, mid+1, right);
		long splitInversion = countSplitInversion(numbers, left, mid, right);
		return leftInversion + rightInverstion + splitInversion;
	}

	private long countSplitInversion(int[] numbers, int left, int mid, int right) {

		int[] copy = new int[right-left+1];
		
		int lptr = left;
		int rptr = mid+1;
		int ptr = 0;
		long count = 0;
		while(lptr <= mid && rptr <= right) {
			if(numbers[lptr] <= numbers[rptr]) {
				copy[ptr++] = numbers[lptr++];
			} else {
				count += (mid - lptr + 1);
				copy[ptr++] = numbers[rptr++];
			}
		}
		
		while(lptr <= mid) {
			copy[ptr++] = numbers[lptr++]; 
		}
		
		while(rptr <= right) {
			copy[ptr++] = numbers[rptr++];
		}
		
		//copy sorted array from array "copy" to original array
		ptr = 0;
		while(ptr < copy.length) {
			numbers[left+ptr] = copy[ptr++];
		}
		
		return count;
	}

	public static void main(String[] args) {
		int n = 100;
		
		// Interesting fact - For finding out array inversion for 3 types of array together
		// brute force algorithm is O(n2)
		// divide and conquer is O(n log n)
		//
		// Running time (in seconds)
		// Input size		brute force			divide-and-conquer
		// -------------------------------------------------------
		// 100				<1					<1
		// 10000			<1					<1
		// 100000			20					<1
		// 1000000			tired-of-waiting	<1
		
		int[] increasingArray = generateIncreasingArray(n);
		int[] decreasingArray = generateDecreasingArray(n);
		int[] randomArray = generateDistinctRandomArray(n);

		testBruteForce(n, increasingArray, decreasingArray, randomArray);
		testDivideAndConquer(n, increasingArray, decreasingArray, randomArray);
	}

	private static void testBruteForce(int n, int[] increasingArray, int[] decreasingArray, int[] randomArray) {
		ArrayInverstion a = new ArrayInverstion();
		long startTime = System.currentTimeMillis();
		System.out.format("Number of inversions for increasing array of %d numbers: %d%n", n, a.bruteForce(increasingArray));
		System.out.format("Number of inversions for decreasing array of %d numbers: %d%n", n, a.bruteForce(decreasingArray));
		System.out.format("Number of inversions for random array of %d numbers: %d%n", n, a.bruteForce(randomArray));
		System.out.println("Time required for testBruteForce:" + (System.currentTimeMillis() - startTime) / 1000);
	}
	
	private static void testDivideAndConquer(int n, int[] increasingArray, int[] decreasingArray, int[] randomArray) {
		ArrayInverstion a = new ArrayInverstion();
		long startTime = System.currentTimeMillis();
		System.out.format("Number of inversions for increasing array of %d numbers: %d%n", n, a.countInversion(increasingArray));
		System.out.format("Number of inversions for decreasing array of %d numbers: %d%n", n, a.countInversion(decreasingArray));
		System.out.format("Number of inversions for random array of %d numbers: %d%n", n, a.countInversion(randomArray));
		System.out.println("Time required for testDivideAndConquer:" + (System.currentTimeMillis() - startTime) / 1000);
	}
}
