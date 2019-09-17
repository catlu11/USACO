package USACO;
import java.io.*;
import java.util.*;

public class SquarePasture {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("square.in");
		Scanner scan = new Scanner(reader);

		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int xx1 = scan.nextInt();
		int yy1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		int xx2 = scan.nextInt();
		int yy2 = scan.nextInt();

		int reqX = Math.max(xx1, xx2) - Math.min(x1, x2);
		int reqY = Math.max(yy1, yy2) - Math.min(y1, y2);
		int reqArea = Math.max(reqX, reqY) * Math.max(reqX, reqY);

		PrintWriter writer = new PrintWriter("square.out");
		writer.println(reqArea);

		scan.close();
		writer.close();
	}
}
