package pahinave.algorithms.sorting;

public interface Sorter {
	public void sort(int[] numbers);
	// NOTE: this sorts elements from start (inclusive) to end (exclusive)
	public void sort(int[] numbers, int start, int end);
}
