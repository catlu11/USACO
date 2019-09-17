package USACO;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CountingHaybales {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("haybales.in");
		Scanner scan = new Scanner(reader);
		PrintWriter writer = new PrintWriter("haybales.out");

		int numBales = scan.nextInt();
		int numCases = scan.nextInt();

		int[] bales = new int[numBales];
		for (int i = 0; i < numBales; i++) {
			bales[i] = scan.nextInt();
		}

		Arrays.sort(bales);

		while (scan.hasNextInt()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int indexA = bales.length - binaryTestG(bales, a);
			int indexB = binaryTestL(bales, b);

			writer.println(indexB - indexA);
		}
		scan.close();
		writer.close();
	}

	public static int binaryTestL(int[] array, int b) {
		int min = 0;
		int max = array.length;

		if (array[array.length - 1] <= b)
			return array.length;

		while (min + 1 != max) {
			int mid = (min + max) / 2;
			if (array[mid] <= b) {
				min = mid;
			} else {
				max = mid;
			}
		}
		return min + 1;
	}

	public static int binaryTestG(int[] array, int a) {
		int min = 0;
		int max = array.length;

		if (array[0] >= a)
			return array.length;

		while (min + 1 != max) {
			int mid = (min + max) / 2;
			if (array[mid] < a) {
				min = mid;
			} else {
				max = mid;
			}
		}
		return array.length - (min + 1);
	}
}