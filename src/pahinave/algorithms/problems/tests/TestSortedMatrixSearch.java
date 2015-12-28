package pahinave.algorithms.problems.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pahinave.algorithms.problems.SortedMatrixSearch;

public class TestSortedMatrixSearch {

	private static int[][] getMatrix() {
		int nRows = 6, nCols = 5;
		int[][] matrix = new int[nRows][nCols];
		int next = 1;
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				matrix[i][j] = next++;
			}
		}
//		System.out.println("Matrix::");
//		for (int i = 0; i < nRows; i++) {
//			System.out.println();
//			for (int j = 0; j < nCols; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//		}
//		System.out.println();

		return matrix;
	}

	@Test
	public void testAllNumbersInMatrix() {
		SortedMatrixSearch m = new SortedMatrixSearch();
		int[][] matrix = getMatrix();
		int nRows = matrix.length;
		int nCols = matrix[0].length;

		for (int number = 1; number <= (nRows * nCols); number++) {
			assertTrue(m.find(getMatrix(), number));
		}
	}

	@Test
	public void testFind50() {
		SortedMatrixSearch m = new SortedMatrixSearch();
		assertFalse(m.find(getMatrix(), 50));

	}

	@Test
	public void testFindMinus2() {
		SortedMatrixSearch m = new SortedMatrixSearch();
		assertFalse(m.find(getMatrix(), -2));

	}
}
