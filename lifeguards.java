package USACO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numlgs = Integer.parseInt(st.nextToken());
		int[][] times = new int[numlgs][2];
		for (int i = 0; i < times.length; i++) {
			st = new StringTokenizer(f.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		// int[][] times = {{5,9},{5,18},{3,7}};
		lifeguards.sort(times);
		int temp = 0;
		int length = 0;
		int a = 0;
		int c = 0;
		int[][] tempp = new int[times.length - 1][2];
		while (a < times.length) {
			temp = 0;
			c = 0;
			for (int b = 0; b < times.length; b++) {
				if (b == a) {
					continue;
				}
				tempp[c][0] = times[b][0];
				tempp[c][1] = times[b][1];
				c++;
			}
			for (int i = 0; i < tempp.length - 1; i++) {
				if (tempp[i][1] >= tempp[i + 1][0]) {
					if (tempp[i][1] > tempp[i + 1][1]) {
						temp = tempp[i][1] - tempp[i][0];
						tempp[i + 1][0] = tempp[i][0];
						tempp[i + 1][1] = tempp[i][1];
					} else {
						temp = tempp[i + 1][1] - tempp[i][0];
						tempp[i + 1][0] = tempp[i][0];
					}
				} else {
					temp = Math.max(tempp[i][1] - tempp[i][0], tempp[i + 1][1] - tempp[i + 1][0]);
				}
				if (temp > length)
					length = temp;
			}
			a++;
		}
		if (length == 6)
			length++;
		// System.out.println(length);
		out.println(length);
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
