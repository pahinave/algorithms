package pahinave.algorithms.problems;

import java.util.Arrays;

public class StringUniqChars {
	public char[] uniqChars(char[] input) {
		if (input == null || input.length < 2) {
			return input;
		}

		int wptr = 1;
		int rptr = 1;
		while (rptr < input.length) {
			int i = 0;
			for (; i < wptr; i++) {
				if (input[i] == input[rptr]) {
					break;
				}
			}
			if (i == wptr) {
				input[wptr++] = input[rptr++];
			} else {
				rptr++;
			}
		}

		return Arrays.copyOfRange(input, 0, wptr);
	}
}
