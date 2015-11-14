package pahinave.algorithms.sorting;

public class SelectionSort implements Sorter {
	@Override
	public void sort(int[] numbers) {
		sort(numbers, 0, numbers.length);
	}
	public void sort(int[] numbers, int start, int end) {
		// is it already sorted?
		if((end-start) < 2) return;
				
		for(int index=start; index < end; index++) {
			// find out the next minimum number to place at index location
			int nextMinNumber = numbers[index];
			int nextMinIndex = index;
			for(int i=index+1; i<end; i++) {
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
