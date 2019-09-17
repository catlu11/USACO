import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: ride
*/

public class ride {
	public static int findP(String str) {
		int product = 1;
		for (int i = 0; i < str.length(); i++) {
			product = (str.charAt(i) - 64) * product;
		}
		return product;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		StringTokenizer cName = new StringTokenizer(f.readLine());
		StringTokenizer gName = new StringTokenizer(f.readLine());

		int cdex = ride.findP(cName.nextToken());
		int gdex = ride.findP(gName.nextToken());

		if (cdex % 47 == gdex % 47) {
			out.println("GO");
		} else {
			out.println("STAY");
		}
		f.close();
		out.close();
	}
}
