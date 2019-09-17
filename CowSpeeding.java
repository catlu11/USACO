package USACO;
import java.io.*;
import java.util.Scanner;

public class CowSpeeding {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("speeding.in");
		Scanner scan = new Scanner(reader);
		PrintWriter writer = new PrintWriter("speeding.out");

		int n = scan.nextInt();
		int m = scan.nextInt();

		int[][] bSpeeds = setSpeeds(n, scan);
		int[][] speedLimits = setSpeeds(m, scan);

		int ans = 0;
		int temp = 0;
		int v = 0;

		for (int i = 0; i < m; i++) {
			while (bSpeeds[v][0] <= speedLimits[i][0] && v < n) {
				if (bSpeeds[v][1] > speedLimits[i][1]) {
					temp = bSpeeds[v][1] - speedLimits[i][1];
					ans = Math.max(temp, ans);
					v++;
				}
			}
		}
		writer.println(ans);
		scan.close();
		writer.close();
	}

	public static int[][] setSpeeds(int length, Scanner scan) {
		int[][] array = new int[length][2];
		for (int i = 0; i < length; i++) {
			array[i][0] = scan.nextInt();
			array[i][1] = scan.nextInt();
		}
		return array;
	}
}
