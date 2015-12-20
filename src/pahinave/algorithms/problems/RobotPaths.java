package pahinave.algorithms.problems;

public class RobotPaths {
	private int n;

	public RobotPaths(int n) {
		this.n = n;
	}

	public void explorePaths(int i, int j, String pathTillNow) {
		if (j + 1 <= n)
			explorePaths(i, j + 1, pathTillNow + " " + i + "" + (j + 1));
		if (i + 1 <= n)
			explorePaths(i + 1, j, pathTillNow + " " + (i + 1) + "" + j);
		if (i == n && j == n) {
			System.out.println(pathTillNow);
		}
	}
	
	public static void main(String[] args) {
		RobotPaths rp = new RobotPaths(4);
		rp.explorePaths(1, 1, "11");
				
	}

}

