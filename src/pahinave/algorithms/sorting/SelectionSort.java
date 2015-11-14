package pahinave.algorithms.sorting;

public class SelectionSort implements Sorter {
	public void sort(int[] numbers) {
		// is it already sorted?
		if(numbers.length < 2) return;
		
		// number of elements
		int l = numbers.length;
		
		for(int index=0; index < l; index++) {
			// find out the next minimum number to place at index location
			int nextMinNumber = numbers[index];
			int nextMinIndex = index;
			for(int i=index+1; i<l; i++) {
				if(numbers[i] < nextMinNumber) {
					nextMinNumber = numbers[i];
					nextMinIndex = i;
				}
			}
			// If current number is not next minimum,
			// exchange them to place next min
			// at index location
			if(nextMinIndex != index) {
				Common.swap(numbers, index, nextMinIndex);
			}
		}
	}

}
