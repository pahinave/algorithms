package pahinave.algorithms.dynamicprogramming;

public class KnapSack {
	public int solve(int[] profits, int[] weights, int capacity) {
		int n = profits.length;
		int[][] workspace = new int[profits.length+1][capacity + 1];
		int[][] takeOrNot = new int[profits.length+1][capacity + 1];
		
		for(int w=0; w<=capacity; w++) {
			workspace[0][w] = 0;
		}
		
		
		for (int v = 1; v < n; v++) { // values
			for (int w = 1; w <= capacity; w++) { // weights
				int max = workspace[v - 1][w];
				if (weights[v] <= w && max < (workspace[v - 1][w - weights[v]] + profits[v])) {
					max = workspace[v - 1][w - weights[v]] + profits[v];
					takeOrNot[v][w] = 1;
				}
				workspace[v][w] = max;
			}
		}
		/*
		for (int v = 1; v < n; v++) { // values
			for (int w = 0; w <= capacity; w++) { // weight
				System.out.print(workspace[v][w] + "." + takeOrNot[v][w] + " ");
			}
			System.out.println();
		}
		*/
		
		int[] take = new int[n];
		for(int i=n-1, w = capacity; i>0; i--) {
			if(takeOrNot[i][w] == 1) {
				take[i] = 1;
				w = w - weights[i];
			} else {
				take[i] = 0;
			}
		}
		
		for(int i=1; i<n; i++) {
			System.out.println(profits[i] + "\t" + weights[i] + "\t" + (take[i] == 1 ? "Take" : "Don't Take"));
		}
		
		return workspace[profits.length-1][capacity];
	}
}
