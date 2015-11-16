package pahinave.algorithms.sorting;

import java.util.function.IntBinaryOperator;

import pahinave.utilities.ArrayUtitilities;

public class QuickSort implements Sorter {
	
	IntBinaryOperator pivotGenerator;
	
	public QuickSort() {
		pivotGenerator = (start, end) -> start;
	}
	
	public QuickSort(IntBinaryOperator pivotGenerator) {
		this.pivotGenerator = pivotGenerator;
	}

	@Override
	public void sort(int[] numbers) {
		sort(numbers, 0, numbers.length);
	}

	@Override
	public void sort(int[] numbers, int start, int end) {
		// base case - single element / no elements
		if((end - start) <= 1) return;
		
		// partition based on pivot = element at index "start"
		int partitionIndex = partition(numbers, start, end);
		sort(numbers, start, partitionIndex);
		sort(numbers, partitionIndex+1, end);
	}

	
	private int partition(int[] numbers, int start, int end) {
		ArrayUtitilities.swap(numbers, start, pivotGenerator.applyAsInt(start, end));
		int pivot = numbers[start];
		int i = start + 1;
		int j = start + 1;
		while(j < end) {
			if(numbers[j] < pivot) {
				ArrayUtitilities.swap(numbers, i, j);
				i++;
			}
			j++;
		}
		ArrayUtitilities.swap(numbers, start, i-1);
		return i-1;
	}
}
