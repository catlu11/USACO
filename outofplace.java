package USACO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class outofplace {

	public static void main(String[] args) throws IOException {
		// // TODO Auto-generated method stub
		// BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new
		// FileWriter("outofplace.out")));
		//
		// StringTokenizer st = new StringTokenizer(f.readLine());
		// int numCows = Integer.parseInt(st.nextToken());
		// int[] heights = new int[numCows];
		// for(int i = 0; i < numCows; i++) {
		// st = new StringTokenizer(f.readLine());
		// heights[i]= Integer.parseInt(st.nextToken());
		// }
		int[] heights = { 5, 4, 7, 7, 9, 11 };
		int numCows = 6;
		boolean ofo = false;
		int index = 0;
		int val = 0;
		for (int i = 0; i < numCows - 1; i++) {
			if (heights[i] > heights[i + 1]) {
				index = i + 1;
				val = heights[index];
				ofo = true;
				break;
			}
		}
		int target = 0;
		for (int i = 0; i < numCows - 1; i++) {
			if (val >= heights[i] && val <= heights[i + 1]) {
				target = i + 1;
			}
		}
		int[] temp = heights;
		int poof;
		int swaps = 0;
		while (!outofplace.isCorrect(temp)) {
			poof = temp[target];
			temp[target] = val;
			temp[index] = poof;
			swaps++;
			index = outofplace.findIndex(temp);
			val = temp[index];
			target = outofplace.findTarget(temp, index);
		}
		// out.println(swaps);
		// out.close();
		System.out.println(swaps);
	}

	public static boolean isCorrect(int[] a) {
		boolean x = true;
		for (int b = 0; b < a.length - 1; b++) {
			if (a[b] > a[b + 1])
				x = false;
		}
		return x;
	}

	public static int findIndex(int[] temp) {
		int index = 0;
		for (int b = 0; b < temp.length - 1; b++) {
			if (temp[b] > temp[b + 1])
				index = b + 1;
		}
		return index;
	}

	public static int findTarget(int[] temp, int index) {
		int target = 0;
		for (int i = 0; i < temp.length - 1; i++) {
			if (temp[index] >= temp[i] && temp[index] <= temp[i + 1]) {
				target = i + 1;
			}
		}
		return target;
	}
}
