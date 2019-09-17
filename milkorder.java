import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class milkorder {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("milkorder.in");
		Scanner scan = new Scanner(reader);
		PrintWriter out = new PrintWriter("milkorder.out");

		// initialize variables
		int numCows = scan.nextInt();
		int numSoc = scan.nextInt();
		int numPos = scan.nextInt();
		int[] hierarchy = new int[numSoc];
		for (int i = 0; i < numSoc; i++) {
			hierarchy[i] = scan.nextInt();
		}
		int[][] positions = new int[numPos][2];
		ArrayList<Integer> overlaps = new ArrayList<Integer>();
		for (int j = 0; j < numPos; j++) {
			positions[j][0] = scan.nextInt();
			positions[j][1] = scan.nextInt();
			if (isLapping(hierarchy, positions[j][0])) {
				overlaps.add(positions[j][0]);
			}
		}

		int[] order = new int[numCows];
		for (int g = 0; g < numCows; g++) {
			order[g] = -1;
		}

		// fill in cows for insistent positions
		for (int n = 0; n < numPos; n++) {
			int index = positions[n][1] - 1;
			order[index] = positions[n][0];
		}

		// figure out valid places for cow 1
		int[] openings = new int[numCows - numPos + overlaps.size() - 1];
		int amt = 0;
		for (int k = 0; k < numCows; k++) {
			if (order[k] == -1) {
				openings[amt] = k;
				amt++;
			}
		}
		boolean found = false;
		int dex = 0;
		while (!found) {
			if (tryAndFill(order, hierarchy, openings[dex], overlaps)) {
				found = true;
				out.println(openings[dex] + 1);
			}
			dex++;
		}
		out.close();
	}

	public static boolean tryAndFill(int[] order, int[] hierarchy, int dex, ArrayList<Integer> overlaps) {
		int[] temp = new int[order.length];
		for (int a = 0; a < temp.length; a++) {
			int p = order[a];
			temp[a] = p;
		}
		temp[dex] = 1;
		int caste = 0;
		for (int i = 0; i < temp.length; i++) {
			if (caste >= hierarchy.length)
				break;
			if (isLapped(overlaps, hierarchy[caste])) {
				caste++;
				if (caste >= hierarchy.length)
					break;
			}
			if (temp[i] == -1 && !isLapped(overlaps, hierarchy[caste])) {
				temp[i] = hierarchy[caste];
				caste++;
			}
		}
		if (isInSocOrder(hierarchy, temp)) {
			boolean i = isInSocOrder(hierarchy, temp);
			return true;
		}
		return false;
	}

	public static boolean isLapping(int[] hierarchy, int cow) {
		for (int i = 0; i < hierarchy.length; i++) {
			if (cow == hierarchy[i])
				return true;
		}
		return false;
	}

	public static boolean isLapped(ArrayList<Integer> a, int p) {
		for (int i = 0; i < a.size(); i++) {
			if (p == a.get(i))
				return true;
		}
		return false;
	}

	public static boolean isInSocOrder(int[] hierarchy, int[] order) {
		int[] oddOrder = new int[hierarchy.length];
		int dex = 0;
		for (int i = 0; i < order.length; i++) {
			if (isLapping(hierarchy, order[i])) {
				oddOrder[dex] = order[i];
				dex++;
			}
		}
		boolean poo = true;
		for (int u = 0; u < hierarchy.length; u++) {
			if (hierarchy[u] != oddOrder[u])
				poo = false;
		}
		if (poo)
			return true;
		else
			return false;
	}
}
