package pahinave.algorithms.sorting;

import java.util.Arrays;

public class MergeSort implements Sorter {
	@Override
	public void sort(int[] numbers) {
		sort(numbers, 0, numbers.length);

	}

	@Override
	public void sort(int[] numbers, int start, int end) {
		// if less than 3 numbers, use insertion sort
		if(end-start<3) {
			new InsertionSort().sort(numbers, start, end);
			return;
		}
		
		int mid = (end+start)/2;
		// sort left half
		sort(numbers, start, mid);
		//sort right half
		sort(numbers, mid, end);
		
		// merge partially sorted sub arrays
		merge(numbers, start, end, mid);

	}

	private void merge(int[] numbers, int start, int end, int mid) {
		// Create a copy of the subarrays to merge
		int[] partiallySortedArrays = Arrays.copyOfRange(numbers, start, end);
		
		// Pointer into the left array
		int lptr = 0;
		
		// Pointer into the right array
		int rptr = mid - start;
		
		// Pointer into the original array for putting the next min element
		int insertPtr = start;
		while(lptr < mid-start && rptr < partiallySortedArrays.length) {
			if(partiallySortedArrays[lptr] < partiallySortedArrays[rptr]) {
				numbers[insertPtr++] = partiallySortedArrays[lptr++];
			} else {
				numbers[insertPtr++] = partiallySortedArrays[rptr++];
			}
		}
		
		// copy remaining elements of left array
		while(lptr < mid-start ) {
			numbers[insertPtr++] = partiallySortedArrays[lptr++];
		}
		
		// copy remaining elements of right array
		while(rptr < partiallySortedArrays.length) {
			numbers[insertPtr++] = partiallySortedArrays[rptr++];
		}

	}
}
