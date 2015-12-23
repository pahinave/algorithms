package pahinave.algorithms.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find all possible ways to place N queens on NxN
 * chess boards so that no two queens are on same
 * row, column and both diagonals
 */
public class NQueensProblem {
	int[] tempSpace;
	int[] map;
	int nQueens;
	List<int[]> solutions;

	public NQueensProblem(int noOfQueens) {
		map = new int[noOfQueens + 1];
		tempSpace = new int[1 + 2 * noOfQueens];
		nQueens = noOfQueens;
		solutions = new ArrayList<>();
	}

	public void solve() {
		solve(1);
	}

	public List<int[]> getSolutions() {
		return solutions;
	}

	private void solve(int queenRow) {
		// find the place for queen number "queenRow"
		// by trying all positions
		//
		// in each try, check if queens from 1...queen are in valid
		// placement. If not, then ignore that location and try next.

		for (int i = 1; i <= nQueens; i++) {
			map[queenRow] = i;
			if (isValidPlacement(queenRow) == false) {
				continue;
			}

			// If current placement of queen in row queenRow
			// is making placements of queens from 1 to queenRow valid
			// and if the current queen is the last queen to be placed,
			// accept that as solution
			if (queenRow == nQueens) {

				Arrays.stream(map).forEach(System.out::print);
				System.out.println();

				solutions.add(Arrays.copyOfRange(map, 1, map.length));
			} else {
				solve(queenRow + 1);
			}
		}
	}

	private boolean isValidPlacement(int queen) {

		// check common columns
		Arrays.fill(tempSpace, 1, nQueens + 1, 0);
		for (int i = 1; i <= queen; i++) {
			if (tempSpace[map[i]] == 1) {
				return false;
			} else {
				tempSpace[map[i]] = 1;
			}
		}

		// check forward diagonal
		Arrays.fill(tempSpace, 1, 2 * nQueens + 1, 0);
		for (int i = 1; i <= queen; i++) {
			if (tempSpace[i + map[i]] == 1) {
				return false;
			} else {
				tempSpace[i + map[i]] = 1;
			}
		}

		// check forward diagonal
		Arrays.fill(tempSpace, 1, 2 * nQueens + 1, 0);
		for (int i = 1; i <= queen; i++) {
			if (tempSpace[queen - i + 1 + map[i]] == 1) {
				return false;
			} else {
				tempSpace[queen - i + 1 + map[i]] = 1;
			}
		}

		return true;

	}
}
