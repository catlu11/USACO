package USACO;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FencePainting {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("paint.in");
		Scanner scan = new Scanner(reader);
		PrintWriter writer = new PrintWriter("paint.out");

		int f1 = scan.nextInt();
		int f2 = scan.nextInt();
		int b1 = scan.nextInt();
		int b2 = scan.nextInt();

		int temp = f1;
		if (b1 < f1) {
			f1 = b1;
			b1 = temp;
			temp = f2;
			f2 = b2;
			b2 = temp;
		}
		int ans = b2 - f1;
		if (b1 > f2) {
			ans = (f2 - f1) + (b2 - b1);
		} else if (b2 < f2) {
			ans = f2 - f1;
		}
		writer.println(ans);
		scan.close();
		writer.close();
	}
}
