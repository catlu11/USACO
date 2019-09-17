import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: transform
*/

public class transform {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[] original = new String[n];
		String[] transformed = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			original[i] = st.nextToken();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			transformed[i] = st.nextToken();
		}
		int transformation;
		String[] temp90 = rotate90(original, n);
		String[] temp180 = rotate90(temp90, n);
		String[] temp270 = rotate90(temp180, n);
		String[] tempR = reflect(original, n);
		String[] tempR90 = rotate90(tempR, n);
		String[] tempR180 = rotate90(tempR90, n);
		String[] tempR270 = rotate90(tempR180, n);
		if (Arrays.equals(temp90, transformed)) {
			transformation = 1;
		} else if (Arrays.equals(temp180, transformed)) {
			transformation = 2;
		} else if (Arrays.equals(temp270, transformed)) {
			transformation = 3;
		} else if (Arrays.equals(tempR, transformed)) {
			transformation = 4;
		} else if (Arrays.equals(tempR90, transformed)) {
			transformation = 5;
		} else if (Arrays.equals(tempR180, transformed)) {
			transformation = 5;
		} else if (Arrays.equals(tempR270, transformed)) {
			transformation = 5;
		} else if (Arrays.equals(original, transformed)) {
			transformation = 6;
		} else {
			transformation = 7;
		}
		out.println(transformation);
		out.close();
		// String[] a = {"@@!@", "----","@@@@","----"};
		// a = reflect(a,4);
		// for(String b : a) {
		// System.out.println(b);
		// }
	}

	public static String[] rotate90(String[] original, int n) {
		String[] temp = new String[n];
		String add = "";
		for (int a = 0; a < n; a++) {
			for (int i = n - 1; i >= 0; i--) {
				add += original[i].charAt(a);
			}
			temp[a] = add;
			add = "";
		}
		return temp;
	}

	public static String[] reflect(String[] original, int n) {
		String[] temp = new String[n];
		String add = "";
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				add += original[i].charAt(j);
			}
			temp[i] = add;
			add = "";
		}
		return temp;
	}
}
