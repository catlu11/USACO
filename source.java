import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: milk2
*/

public class source {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int farmers = Integer.parseInt(st.nextToken());
		int[][] times = new int[farmers][2];
		for (int i = 0; i < farmers; i++) {
			st = new StringTokenizer(f.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		// int farmers = 4;
		// int[][] times = {{2000,4000},{10,15},{5,13},{16,17}};
		source.sort(times);
		int tempGap = 0;
		int tempMilk = 0; // 2 55 3 55 4 55 57 60
		int lGap = 0;
		int lMilk = 0;
		int sLock = 0;
		boolean cont = false;
		for (int a = 0; a < farmers - 1; a++) {
			if (times[a][1] > times[a + 1][0]) {
				if (times[a][1] > times[a + 1][1]) {
					if (!cont)
						sLock = times[a][1];
					cont = true;
					times[a + 1][1] = times[a][1];
					tempMilk = times[a][1] - times[a][0];
				} else {
					if (cont) {
						cont = false;
						tempMilk = times[a][1] - sLock;
						if (tempMilk > lMilk)
							lMilk = tempMilk;
					}
					if (times[a + 1][1] < times[a][1])
						tempMilk = times[a][1] - times[a][0];
					else
						tempMilk = times[a + 1][1] - times[a][0];
				}
			} else if (times[a][1] == times[a + 1][0]) {
				times[a + 1][0] = times[a][0];
			} else {
				tempMilk = Math.max(times[a][1] - times[a][0], times[a + 1][1] - times[a + 1][0]);
				tempGap = times[a + 1][0] - times[a][1];
			}
			if (tempMilk > lMilk)
				lMilk = tempMilk;
			if (tempGap > lGap)
				lGap = tempGap;
		}
		if (farmers == 1) {
			lMilk = times[0][1] - times[0][0];
			lGap = 0;
		}
		// System.out.println(lMilk + " " + lGap);
		out.println(lMilk + " " + lGap);
		out.close();
	}

	public static int[][] sort(int[][] times) {
		boolean swapped = true;
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
		return times;
	}
}
