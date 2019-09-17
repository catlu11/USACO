import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: friday
*/

public class friday {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int years = Integer.parseInt(st.nextToken());
		// int years = 20;
		int leapYears = (years - 1) / 4;
		for (int i = 2000; i < 1900 + years; i += 100) {
			if (i % 400 != 0)
				leapYears--;
		}
		int days = years * 365 + leapYears;
		int[] mdays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] ans = new int[7];
		int month = 0;
		int yearsPassed = 0;
		int cdays;
		int prevT = 1;
		while (days > 0) {
			if (yearsPassed == 0 && month == 0) {
				cdays = 12;
			} else if (yearsPassed % 4 == 0 && yearsPassed != 0 && month == 2) {
				if (yearsPassed % 100 == 0 && (1900 + yearsPassed) % 400 != 0) {
					cdays = 28;
				} else {
					cdays = 29;
				}
			} else {
				cdays = mdays[month - 1];
			}
			if (days - cdays < 0) {
				break;
			} else {
				days -= cdays;
			}
			int temp = cdays % 7;
			int curT = prevT + temp;
			if (curT > 7) {
				curT -= 7;
			}
			switch (curT) {
			case 1:
				ans[2]++;
				break;
			case 2:
				ans[3]++;
				break;
			case 3:
				ans[4]++;
				break;
			case 4:
				ans[5]++;
				break;
			case 5:
				ans[6]++;
				break;
			case 6:
				ans[0]++;
				break;
			case 7:
				ans[1]++;
				break;
			}
			prevT = curT;
			month++;
			if (month == 13) {
				month = 1;
				yearsPassed++;
			}
		}
		String str = ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + " " + ans[4] + " " + ans[5] + " " + ans[6];
		// for(int item: ans) {
		//// System.out.print(item + " ");
		// }
		// System.out.println(str);
		out.println(str);
		f.close();
		out.close();
	}

}
