package pahinave.algorithms.problems;

public class Fibonacci {
	public int fibonacci(int nth) {
		if (nth == 0) {
			return 0;
		}
		if (nth == 1) {
			return 1;
		}
		int n_2 = 0;
		int n_1 = 1;
		int result = 0;
		for (int i = 2; i <= nth; i++) {
			result = n_1 + n_2;
			n_2 = n_1;
			n_1 = result;
		}
		return result;
	}
}
