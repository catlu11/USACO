package USACO;
import java.io.*;
import java.util.Scanner;

public class CowGames {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("cowsignal.in");
		Scanner scan = new Scanner(reader);
		PrintWriter writer = new PrintWriter("cowsignal.out");

		scan.nextInt();
		scan.nextInt();
		int mult = scan.nextInt();
		scan.nextLine();

		while (scan.hasNextLine()) {
			String cur = scan.nextLine();
			String temp = "";

			for (int i = 0; i < cur.length(); i++) {
				int a = 0;
				while (a < mult) {
					temp += cur.charAt(i);
					a++;
				}
			}
			for (int k = 0; k < mult; k++) {
				writer.println(temp);
			}
		}
		scan.close();
		writer.close();
	}
}
