package USACO;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/priyanka-and-toys

public class PriyankaToys {
	public int numToys(int numT, int[] weights) {
		int temp1 = 0;
		int temp2 = 0;
		int curFree = 0;
		int actFree = 0;

		for (int i = 0; i < weights.length; i++) {
			temp1 = weights[i];
			temp2 = weights[i] + 4;

			for (int j = 0; j < weights.length; j++) {
				if (weights[j] >= temp1 && weights[j] <= temp2) {
					curFree++;
				}
			}
			if (curFree > actFree) {
				actFree = curFree;
			}
			curFree = 0;
		}
		return weights.length - actFree + 1;
	}

	public static void main(String[] args) {
		// PriyankaToys test = new PriyankaToys();
		// int[] testy = {1, 2, 3};
		//
		// System.out.println(test.numToys(3, testy));
		int[][] a = { { 3, 5 }, { 2, 3 }, { 2, 4 }, { 1, 14 } };
		PriyankaToys.sort(a);
		System.out.println(a.length);
		System.out.println(a[0][1] + " " + a[1][0] + " " + a[2][0] + " " + a[3][0]);
	}

	public static int[][] sort(int[][] times) {
		boolean swapped = true;
		int j = 0;
		int tmp, tmp2;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < times.length - 1; i++) {
				if (times[i][0] > times[i + 1][0]) {
					tmp = times[i][0];
					tmp2 = times[i][1];
					times[i][0] = times[i + 1][0];
					times[i + 1][0] = tmp;
					times[i][1] = times[i + 1][1];
					times[i + 1][1] = tmp2;
					swapped = true;
				}
			}
		}
		return times; // 1133468
	}
}
