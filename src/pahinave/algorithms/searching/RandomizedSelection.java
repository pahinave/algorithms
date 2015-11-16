package pahinave.algorithms.searching;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

import pahinave.algorithms.sorting.QuickSort;
import pahinave.utilities.ArrayUtitilities;

public class RandomizedSelection {
	IntBinaryOperator pivotSelector;
	
	public RandomizedSelection() {
		pivotSelector = (left, right) -> left;
	}
		
	public RandomizedSelection(IntBinaryOperator pivotSelector) {

		this.pivotSelector = pivotSelector;
	}


	public int randomizedSelect(int[] numbers, int orderStatistic) {
		return randomizedSelect(numbers, 0, numbers.length-1, orderStatistic);
	}
	
	public int randomizedSelect(int[] numbers, int left, int right, int orderStatistic) {
		ArrayUtitilities.swap(numbers, left, pivotSelector.applyAsInt(left, right));
		int pivotIndex = partition(numbers, left, right);
		if(pivotIndex == orderStatistic) {
			return numbers[orderStatistic];
		} else if (pivotIndex < orderStatistic) {
			return randomizedSelect(numbers, pivotIndex+1, right, orderStatistic);
		} else {
			return randomizedSelect(numbers, left, pivotIndex-1, orderStatistic);
		}
	}

	private int partition(int[] numbers, int left, int right) {
		int pivot = numbers[left];
		int i = left + 1;
		int j = left + 1;
		while(j <= right) {
			if(numbers[j] < pivot) {
				ArrayUtitilities.swap(numbers, j, i);
				i++;
			}
			j++;
		}
		ArrayUtitilities.swap(numbers, left, i-1);
		return i-1;
	}
	
	public static void main(String[] args) {
		int n = 100;
		int[] numbers = ArrayUtitilities.generateRandomArray(n);
		int[] originalNumbers = Arrays.copyOf(numbers, numbers.length);
		ArrayUtitilities.printArray("Numbers:", numbers);
		
		RandomizedSelection rs = new RandomizedSelection();
		
		System.out.format("Order statistic 1: %d%n",  rs.randomizedSelect(numbers, 1));
		System.out.format("Order statistic 99: %d%n",  rs.randomizedSelect(numbers, 99));
		System.out.format("Order statistic 50: %d%n",  rs.randomizedSelect(numbers, 50));
		System.out.format("Order statistic 35: %d%n",  rs.randomizedSelect(numbers, 35));
		System.out.format("Order statistic 77: %d%n",  rs.randomizedSelect(numbers, 77));
		
		System.out.println("\n\nCross check after sorting the original array:");
		new QuickSort().sort(originalNumbers);
		System.out.format("%d %d %d %d %d%n", originalNumbers[1], originalNumbers[99], originalNumbers[50], originalNumbers[35], originalNumbers[77]);
	}
}
