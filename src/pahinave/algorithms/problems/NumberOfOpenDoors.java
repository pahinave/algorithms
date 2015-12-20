package pahinave.algorithms.problems;

public class NumberOfOpenDoors {
	public int numberOfOpenDoors(int nDoors) {
		int[] nDividers = new int[nDoors + 1];
		for (int i = 1; i <= nDoors; i++) {
			for (int j = i; j <= nDoors; j += i) {
				nDividers[j]++;
			}
		}

		int nOpenDoors = 0;
		for (int i = 1; i <= nDoors; i++) {
			if (nDividers[i] % 2 != 0) {
				nOpenDoors += 1;
			}
		}
		System.out.println(nDividers);

		return nOpenDoors;
	}
}