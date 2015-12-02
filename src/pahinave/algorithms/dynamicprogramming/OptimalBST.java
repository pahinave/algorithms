package pahinave.algorithms.dynamicprogramming;

public class OptimalBST {
	public int solve(int[] freq) {
		int n = freq.length - 1;
		//IMPORTANT - Solution is of higher dimention
		//so that the code is readble
		//The frequencies start from index 1 (index 0 is not used)

		// solutions also index from 1..n
		// i.e. each entry [i,j] of solution gives
		// cost of optimal BST for range i..j (inclusive)
		// Also, each entry of root gives, which
		// index is selected as root for range i..j
		int[][] sol = new int[n + 1][n + 1];
		int[][] root = new int[n + 1][n + 1];
		for (int s = 0; s < n; s++) {
			for (int i = 1; i <= n; i++) {
				int start = i;
				int end = start + s;
				if (end > n) {
					// subproblem range is out of array,
					// do not solve the problem
					continue;
				}
				int sumProb = 0;
				for (int l = start; l <= end && l <= n; l++) {
					sumProb += freq[l];
				}

				int minCost = Integer.MAX_VALUE;
				int rootSelection = -1;
				for (int l = start; l <= end && l <= n; l++) {
					int cost = sumProb;
					// find cost of start to l (if l is not start)
					if (l != start && l > 0) {
						cost += sol[start][l - 1];
					}

					// find cost only if l is not end 
					if (l != end && l < n) {
						cost += sol[l + 1][end];
					}
					
					if (cost < minCost) {
						minCost = cost;
						rootSelection = l;
					}
				}

				sol[start][end] = minCost;
				root[start][end] = rootSelection;
			}
		}

		System.out.println("Solution Matrix - Answer [1,n] (output is cost/root)");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				System.out.print(sol[i][j] + "/" + root[i][j] + "\t");
			}
			System.out.println();
		}
		return sol[1][n];

	}
}
