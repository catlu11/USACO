package USACO;
import java.io.*;
import java.util.*;

public class BlockGame {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("blocks.in");
		Scanner scan = new Scanner(reader);
		PrintWriter writer = new PrintWriter("blocks.out");
		scan.nextInt();

		ArrayList<Integer> letters = new ArrayList<Integer>();
		ArrayList<Integer> tempAr1 = new ArrayList<Integer>();
		ArrayList<Integer> tempAr2 = new ArrayList<Integer>();

		for (int i = 0; i < 26; i++) {
			letters.add(0);
			tempAr1.add(0);
			tempAr2.add(0);
		}

		String b1 = "";
		String b2 = "";

		while (scan.hasNext()) {
			b1 = scan.next();
			b2 = scan.next();

			for (int i = 0; i < b1.length(); i++) {
				char temp = b1.charAt(i);
				for (int j = 0; j < 26; j++) {
					char test = (char) ('a' + j);
					if (temp == test)
						tempAr1.set(j, tempAr1.get(j) + 1);
				}
			}
			for (int k = 0; k < b2.length(); k++) {
				char temp2 = b2.charAt(k);
				for (int l = 0; l < 26; l++) {
					char test2 = (char) ('a' + l);
					if (temp2 == test2)
						tempAr2.set(l, tempAr2.get(l) + 1);
				}
			}

			for (int q = 0; q < 26; q++) {
				int actual = Math.max(tempAr1.get(q), tempAr2.get(q));
				letters.set(q, letters.get(q) + actual);
			}
			for (int p = 0; p < 26; p++) {
				tempAr1.set(p, 0);
				tempAr2.set(p, 0);
			}
		}

		for (int m = 0; m < letters.size(); m++) {
			writer.println(Integer.toString(letters.get(m)));
		}
		scan.close();
		writer.close();
	}
}
