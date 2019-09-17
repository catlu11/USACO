import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
ID: 2111catlu1
LANG: JAVA
TASK: milk2
*/

public class milk2 {
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
		// int farmers = 3;
		// int[][] times = {{2,32},{2,5},{6,7}};
		milk2.sort(times);
		int tMilk = 0;
		int tGap = 0;
		int lMilk = 0;
		int lGap = 0;
		for (int i = 0; i < farmers - 1; i++) {
			// if(times[a][1] > times[a+1][0]) {
			// if(times[a][1] <= times[a+1][1]) {
			// tMilk = times[a+1][1] - times[a][0];
			// }
			// else {
			// times[a+1][0] = times[a][0];
			// times[a+1][1] = times[a][1];
			// if(a + 1 == farmers - 1) tMilk = times[a + 1][1] - times[a + 1][0];
			// }
			// }
			// else if(times[a][1] == times[a+1][0]) {
			// times[a+1][0] = times[a][0];
			// if(a + 1 == farmers - 1) tMilk = times[a + 1][1] - times[a + 1][0];
			// }
			// else {
			// tMilk = Math.max(times[a][1] - times[a][0],times[a+1][1] - times[a+1][0]);
			// tGap = times[a+1][0] - times[a][1];
			// }
			if (times[i][1] >= times[i + 1][0]) {
				if (times[i][1] > times[i + 1][1]) {
					tMilk = times[i][1] - times[i][0];
					times[i + 1][0] = times[i][0];
					times[i + 1][1] = times[i][1];
				} else {
					tMilk = times[i + 1][1] - times[i][0];
					// System.out.println(tempp[i][0] + " " + tempp[i][1]);
					times[i + 1][0] = times[i][0];

				}
			} else {
				tMilk = Math.max(times[i][1] - times[i][0], times[i + 1][1] - times[i + 1][0]);
				tGap = times[i + 1][0] - times[i][1];
				// System.out.println(temp);
			}
			if (tMilk > lMilk)
				lMilk = tMilk;
			if (tGap > lGap)
				lGap = tGap;
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
