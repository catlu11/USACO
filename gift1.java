import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: gift1
*/

public class gift1 {
	public static int findIndex(String str, String[] list) {
		for (int i = 0; i < list.length; i++) {
			if (str.equals(list[i]))
				return i;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int np = Integer.parseInt(st.nextToken());
		String[] names = new String[np];
		int[] balances = new int[np];
		for (int i = 0; i < np; i++) {
			st = new StringTokenizer(f.readLine());
			names[i] = st.nextToken();
		}
		for (int i = 0; i < np; i++) {
			st = new StringTokenizer(f.readLine());
			int ix = gift1.findIndex(st.nextToken(), names);
			st = new StringTokenizer(f.readLine());
			int gift = Integer.parseInt(st.nextToken());
			int reci = Integer.parseInt(st.nextToken());
			balances[ix] -= gift;
			if ((reci != 0) && (gift % reci != 0)) {
				balances[ix] += (gift % reci);
			}
			for (int j = 0; j < reci; j++) {
				int temp = gift / reci;
				st = new StringTokenizer(f.readLine());
				balances[findIndex(st.nextToken(), names)] += temp;
			}

		}
		for (int i = 0; i < np; i++) {
			out.println(names[i] + " " + balances[i]);
		}
		f.close();
		out.close();
	}
}
