package pahinave.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Common {

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static boolean isArraySorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static int[] generateIncreasingArray(int n) {
		return IntStream.range(0, n).toArray();
	}

	public static int[] generateDecreasingArray(int n) {
		int n_1 = n - 1;
		return IntStream.range(0, n).map(i -> n_1 - i).toArray();
	}

	public static int[] generateRandomArray(int n) {
		Random r = new Random();
		return IntStream.generate(() -> r.nextInt(100)).limit(n).toArray();
	}
	
	public static int[] generateSameNumberArray(int n) {
		return IntStream.generate(() -> 123).limit(n).toArray();
	}

	public static void printArray(String message, int[] array) {
		System.out.print(message + ": ");
		Arrays.stream(array).forEach(n -> System.out.print(n + " "));
		System.out.println("");
	}
	
}
