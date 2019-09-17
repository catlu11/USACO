import java.io.*;
import java.util.Scanner;

/*
ID: 2111catlu1
LANG: JAVA
TASK: beads
*/

public class crypt1 {
	static int numDigits;
	static int[] numSet, thr_numSet;
	static int answer; 
	
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("crypt1.in");
		Scanner scan = new Scanner(reader);
		PrintWriter out = new PrintWriter("crypt1.out");
		
		// get data
		numDigits = scan.nextInt();
		numSet = new int[numDigits];
		for(int i = 0; i < numDigits; i++) numSet[i] = scan.nextInt();
		
		// iterate through all possible three digit numbers
			// take one three digit number
				// find the numbers that will result in suitable partial products
				// find how many combinations of partial products (including themselves) work
			// add to answer
		// print answer	
	}
}
