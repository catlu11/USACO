import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: dualpal
*/

public class dualpal {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int nums = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken()) + 1;

		int count = 0;
		while (count < nums) {
			int temp = 0;
			for (int i = 2; i <= 10; i++) {
				String baseTemp = baseNum(lim, i);
				if (isPalindrome(baseTemp))
					temp++;
			}
			if (temp >= 2) {
				count++;
				out.println(lim);
			}
			lim++;
		}
		out.close();
	}

	public static String baseNum(int n, int b) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (n > 0) {
			digits.add(0, n % b);
			n = n / b;
		}
		String ans = "";
		for (int i = 0; i < digits.size(); i++) {
			ans += Integer.toString(digits.get(i));
		}
		return ans;
	}

	public static boolean isPalindrome(String a) {
		if (a.length() == 1) {
			return true;
		} else {
			for (int i = 0; i < a.length() / 2; i++) {
				if (a.charAt(i) != a.charAt(a.length() - i - 1))
					return false;
			}
		}
		return true;
	}
}
