package pahinave.algorithms.divideandconquer;

import pahinave.utilities.ArrayUtitilities;

public class BinarySearch {
	public int search(int[] numbers, int find) {
		// No numbers in the array
		if(numbers.length == 0) {
			return -1;
		}
		
		// number to look for is less than min or 
		// higher than max -> cannot be in array
		if(find < numbers[0] || find > numbers[numbers.length-1]) {
			return -1;
		}
		
		return search(numbers, find, 0, numbers.length - 1);
	}
	
	public int search(int[] numbers, int find, int left, int right) {
		if(left > right || left < 0 || right < 0) {
			return -1;
		}
		
		// Check if find is present at the center of the sub array left ... right (inclusive)
		int mid = (left + right) / 2;
		if(numbers[mid] == find) {
			return mid;
		}
		
		if(find < numbers[mid]) {
			return search(numbers, find, left, mid-1);
		} else {
			return search(numbers, find, mid+1, right);
		}
	}
	
	public static void main(String[] args) {
		int n = 100;
		int[] numbers = ArrayUtitilities.generateRandomSortedArray(n);
		ArrayUtitilities.printArray("Random sorted array", numbers);
		
		BinarySearch b = new BinarySearch();
		
		// number less than first number in array - should return -1
		System.out.format("Search for %d : %d%n", numbers[0] - 1, b.search(numbers, numbers[0]-1));
		
		// number greater than last number in array - should return -1
		System.out.format("Search for %d : %d%n", numbers[n-1] + 1, b.search(numbers, numbers[n-1]+1));
		
		// some success usage cases with standard / random search indexes
		System.out.format("Search for %d : %d%n", numbers[n/2], b.search(numbers, numbers[n/2]));
		System.out.format("Search for %d : %d%n", numbers[n/4], b.search(numbers, numbers[n/4]));
		System.out.format("Search for %d : %d%n", numbers[3 * n/4], b.search(numbers, numbers[3 * n/4]));
		System.out.format("Search for %d : %d%n", numbers[77], b.search(numbers, numbers[77]));
		System.out.format("Search for %d : %d%n", numbers[0], b.search(numbers, numbers[0]));
		System.out.format("Search for %d : %d%n", numbers[99], b.search(numbers, numbers[99]));
		
		// possible unsuccessful case, number 1 more than valid number in array
		// This will not be present in the array for indexes > 0 as the 
		// numbers are generated similar (not same) to fibonnaci sequence by
		// adding all previous numbers to current random number at particular
		// index location
		System.out.format("Search for %d : %d%n", numbers[51]+1, b.search(numbers, numbers[51]+1));
		
	}
}
