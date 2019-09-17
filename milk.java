import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: milk
*/

public class milk {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("milk.in");
		Scanner scan = new Scanner(reader);
		PrintWriter out = new PrintWriter("milk.out");

		int req = scan.nextInt();
		int farmers = scan.nextInt();
		int[] amts = new int[farmers];
		int[] prices = new int[farmers];
		int temp = 0;
		while (scan.hasNextInt()) {
			prices[temp] = scan.nextInt();
			amts[temp] = scan.nextInt();
			temp++;
		}

		for (int i = 0; i < farmers; i++) {
			int smallest = prices[i];
			int index = i;
			for (int j = i; j < farmers; j++) {
				if (prices[j] < smallest) {
					index = j;
					smallest = prices[j];
				}
			}
			int boop = prices[i];
			prices[i] = smallest;
			prices[index] = boop;
			int aoop = amts[i];
			amts[i] = amts[index];
			amts[index] = aoop;
		}
		int total = 0;
		int farmerID = 0;
		while (req > 0) {
			if (amts[farmerID] >= req) {
				total += (req * prices[farmerID]);
				req = 0;
			} else {
				req -= amts[farmerID];
				total += (prices[farmerID] * amts[farmerID]);
				farmerID++;
			}
			// System.out.println(total);
		}
		out.println(total);
		out.close();
	}
}
