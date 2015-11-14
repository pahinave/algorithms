package pahinave.algorithms.sorting;

public class InsertionSort implements Sorter {

	@Override
	public void sort(int[] numbers) {
		sort(numbers, 0, numbers.length);
	}
	
	public void sort(int[] numbers, int start, int end) {
		// is it already sorted?
		if((end-start) < 2) return;
		
		// move number at index i at correct location
		for(int i=start+1; i<end; i++) {
			
			int j = i;
			int numberAtI = numbers[i];
			// shifts all elements at positions between 0 and i-1 (inclusive)
			// and which are bigger than number at i by 1 to right
			for( ; j>start && numbers[j-1] > numberAtI; j--) {
				numbers[j] = numbers[j-1];
			}
			
			// copy the number at i at the location
			// emptied by last move of element
			numbers[j] = numberAtI;
		}

	}

}
