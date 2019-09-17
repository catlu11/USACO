package USACO;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CowMilk {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("notlast.in");
		Scanner scan = new Scanner(reader);
		PrintWriter writer = new PrintWriter("notlast.out");

		int cowNum = scan.nextInt();
		String[] names = new String[cowNum];
		int[] amts = new int[cowNum];
		ArrayList<Integer> newAmts = new ArrayList<Integer>();
		ArrayList<String> newNames = new ArrayList<String>();

		for (int i = 0; i < cowNum; i++) {
			names[i] = scan.next();
			int m = scan.nextInt();
			amts[i] = m;
		}
		for (int p = 0; p < cowNum; p++) {
			String name = names[p];
			int a = 0;
			boolean b = false;
			for (int y = 0; y < newNames.size(); y++) {
				if (name.equals(newNames.get(y))) {
					b = true;
					break;
				}
			}
			if (!b) {
				for (int x = 0; x < names.length; x++) {
					if (name.equals(names[x]))
						a += amts[x];
				}
				newAmts.add(a);
				newNames.add(name);
			}
		}
		int[] track = CowMilk.tracker(newAmts);
		String[] ans = { newNames.get(0), newNames.get(1) };

		for (int i = 2; i < newAmts.size(); i++) {
			if (newAmts.get(i) < track[0]) {
				track[1] = track[0];
				track[0] = newAmts.get(i);
				ans[1] = ans[0];
				ans[0] = newNames.get(i);

			} else if (newAmts.get(i) == track[0]) {
				continue;
			} else if (newAmts.get(i) < track[1]) {
				track[1] = newAmts.get(i);
				ans[1] = newNames.get(i);
			}
		}

		int v = 0;
		for (int d = 0; d < newAmts.size(); d++) {
			if (track[1] == newAmts.get(d)) {
				v++;
			}
		}
		if (v == 1) {
			writer.println(ans[1]);
		} else {
			writer.println(newAmts.get(6));
		}
		scan.close();
		writer.close();
	}

	public static int[] tracker(ArrayList<Integer> newAmts) {
		int[] track = { newAmts.get(0), newAmts.get(1) };
		Arrays.sort(track);
		return track;
	}
	// public static String[] calc(ArrayList<Integer> newAmts, ArrayList<String>
	// newNames) {
	//
	// }
}
