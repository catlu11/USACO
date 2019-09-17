import java.io.*;
import java.util.*;

/*
ID: 2111catlu1
LANG: JAVA
TASK: barn1
*/

public class barn1 {
	static int currentBoards = 1;
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("barn1.in");
		Scanner scan = new Scanner(reader);
		PrintWriter out = new PrintWriter("barn1.out");
//		
		int maxBoards = scan.nextInt();
//		int maxBoards = 4;
		int totalStalls = scan.nextInt();
//		int totalStalls = 50;
		int numCows = scan.nextInt();
//		int numCows = 18;
		int[] occupiedStalls = new int[totalStalls];
		int temp = 0;
		while(temp < numCows) {
			occupiedStalls[scan.nextInt() - 1] = 1;
			temp++;
		}
//		int[] occupiedStalls = {0,0,1,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,
//				1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0};

		int[] boardedStalls = new int[totalStalls];
		for(int i = 0; i < totalStalls; i++) boardedStalls[i] = 1;
		
		while(currentBoards < maxBoards) { 
			if(barn1.splitBigBoard(occupiedStalls, boardedStalls))
				currentBoards++;
			else
				break;
//			System.out.println(currentBoards);
		}
		if(occupiedStalls[0] == 0 && boardedStalls[1] == 1) {
			for(int h = 0; h < occupiedStalls.length; h++) {
				if(occupiedStalls[h] == 0 && boardedStalls[h] == 1) 
					boardedStalls[h] = 0;
				else
					break;
			}
		}
		if(occupiedStalls[occupiedStalls.length-1] == 0 && boardedStalls[occupiedStalls.length-1] == 1) {
			for(int h = occupiedStalls.length-1; h > 0; h--) {
				if(occupiedStalls[h] == 0 && boardedStalls[h] == 1) 
					boardedStalls[h] = 0;
				else
					break;
			}
		}
		int totalStallsCovered = 0;
		for(int y = 0; y < boardedStalls.length; y++) {
			if(boardedStalls[y] == 1) totalStallsCovered++;
		}
		System.out.println("Boards: " + currentBoards);
		out.println(totalStallsCovered);
		out.close();
		System.out.println("Ans: " + totalStallsCovered);
	}
	public static boolean splitBigBoard(int[] occupiedStalls, int[] boardedStalls) {
		int bigDifDex = 0;
		int currentDif = 0;
		int bigDif = 0;
		for(int i = 0; i < occupiedStalls.length; i++) {
			if(occupiedStalls[i] == 0 && boardedStalls[i] == 1) {
				for(int j = i; j < occupiedStalls.length; j++) {
					if(occupiedStalls[j] == 0) 
						currentDif++;
					else 
						break;
				}
				if(currentDif > bigDif) {
					bigDif = currentDif;
					bigDifDex = i;
				}
				i+=currentDif;
				currentDif = 0;
			}
		}
		for(int k = bigDifDex; k < bigDifDex+bigDif; k++) {
			boardedStalls[k] = 0;
		}
		if(bigDif > 0) {
			if(bigDifDex == 0) currentBoards--;
			if(bigDifDex + bigDif == occupiedStalls.length) currentBoards--;
			return true;
		}
		return false;
	}
}
