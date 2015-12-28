package pahinave.algorithms.problems;

public class SortedMatrixSearch {
	public boolean find(int[][] matrix, int number) {
		int nRows = matrix.length;
		int nCols = matrix[0].length;

		/*
		 * Start at right top corner of matrix
		 * If number matches at current location, return true
		 * If number at current location is less number to search for,
		 * 		the number to search for has to be on row greater than current row
		 * else if number at current location is greater than number to search for
		 * 		the number to search for has to in some column before current column
		 */
		int r = 0;
		int c = nCols - 1;
		
		while (r < nRows && c >= 0) {
			if (matrix[r][c] == number) {
				return true;
			} else if (number > matrix[r][c]) {
				r++;
			} else {
				c--;
			}
		}
		return false;
	}
}
