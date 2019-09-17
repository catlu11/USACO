import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
ID: 2111catlu1
LANG: JAVA
TASK: palsquare
*/
public class palsquare {
	public static String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		// FileReader reader = new FileReader("palsquare.out");
		// Scanner scan = new Scanner(reader);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int base = Integer.parseInt(st.nextToken());

		int n = 1;
		while (n <= 300) {
			boolean isPal = false;
			String baseN = baseNum(n, base);
			int squared = (int) Math.pow(n, 2);
			String baseQ = baseNum(squared, base);
			if (isPalindrome(baseQ))
				isPal = true;
			if (isPal)
				out.println(baseN + " " + baseQ);
			n++;
		}
		out.close();
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

	public static String baseNum(int n, int b) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (n > 0) {
			// System.out.println(n % b);
			digits.add(0, n % b);
			n = n / b;
		}
		String ans = "";
		for (int i = 0; i < digits.size(); i++) {
			if (digits.get(i) < 10) {
				ans += Integer.toString(digits.get(i));
			} else {
				int temp = digits.get(i) - 10;
				ans += letters[temp];
			}
			// System.out.println(ans);
		}
		return ans;
	}
}
