package pahinave.algorithms.sorting;

import static pahinave.algorithms.sorting.Common.*;

public class BubbleSort implements Sorter{

	@Override
	public void sort(int[] numbers) {
		if(numbers.length == 0) return;
		
		for(int i=numbers.length-1; i > 0; i--) {
			for(int j=0; j<i; j++) {
				if(numbers[j] > numbers[j+1]) {
					swap(numbers, j, j+1);
				}
			}
		}
	}

}
