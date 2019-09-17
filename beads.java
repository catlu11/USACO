import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: beads
*/

public class beads {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int numBeads = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		String necklace = st.nextToken();

		// String necklace = "wbwbwr";
		char temp;
		int collected = 0;
		int largest = 0;
		String br = necklace;
		for (int i = 0; i < necklace.length(); i++) {
			br = necklace.substring(i, necklace.length()) + necklace.substring(0, i);
			temp = br.charAt(0);
			if (temp == 'w') {
				collected = Math.max(collect(br, 'r'), collect(br, 'b'));
			} else {
				collected = collect(br, temp);
			}
			if (collected > largest)
				largest = collected;
			System.out.println(br + "   " + collected);
			collected = 0;
		}
		// System.out.println(largest);
		out.println(largest);
		out.close();
	}

	public static int collect(String br, char temp) {
		int collected = 0;
		int dex = 0;
		for (int j = 0; j < br.length(); j++) {
			if (br.charAt(j) == temp || br.charAt(j) == 'w') {
				collected++;
			} else {
				dex = j;
				break;
			}
			if (j + 1 == br.length())
				dex = br.length();
		}
		for (int i = dex; i < br.length(); i++) {
			if (br.charAt(i) == br.charAt(dex) || br.charAt(i) == 'w') {
				collected++;
			} else {
				break;
			}
		}
		return collected;
	}
}
