package pahinave.algorithms.sorting;

import static pahinave.utilities.ArrayUtitilities.*;

public class BubbleSort implements Sorter{

	@Override
	public void sort(int[] numbers) {
		sort(numbers, 0, numbers.length);
	}

	@Override
	public void sort(int[] numbers, int start, int end) {

		// Is it already sorted?
		if((end-start) < 2) return;
		
		for(int i=end-1; i > start; i--) {
			for(int j=start; j<i; j++) {
				if(numbers[j] > numbers[j+1]) {
					swap(numbers, j, j+1);
				}
			}
		}
	}


}
