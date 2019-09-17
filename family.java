import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class family {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("family.in");
		Scanner scan = new Scanner(reader);
		PrintWriter out = new PrintWriter("family.out");

		int n = scan.nextInt();
		String cowOne = scan.next();
		String cowTwo = scan.next();
		String[][] relations = new String[n][2];
		for (int i = 0; i < n; i++) {
			relations[i][0] = scan.next();
			relations[i][1] = scan.next();
		}
		String ans = "";

		// case 1: mother, grandmother, etc.
		String mom = cowOne;
		boolean isDirectDescendant = false;
		int gens = 0;
		while (!mom.equals("!") || isDirectDescendant) {
			mom = findMom(mom, relations);
			if (mom.equals(cowTwo))
				isDirectDescendant = true;
		}
		if (gens == 0) {
			ans = "mother";
		} else if (gens == 1) {
			ans = "grandmother";
		} else {
			for (int p = 0; p < gens - 1; p++) {
				ans += "great-";
			}
			ans += "grand-mother";
		}

		// case 2: aunts
		mom = cowOne;
		boolean isAunt = false;
		gens = 0;
		while (!mom.equals("!") || isAunt) {
			mom = findMom(mom, relations);
			String[] sibs = findSiblings(mom, cowOne, relations);
			if (isPart(sibs, findMom(cowTwo, relations))) {
				isAunt = true;
			}
			gens++;
		}
		if (gens == 0) {
			ans = "aunt";
		} else {
			for (int p = 0; p < gens; p++) {
				ans += "great-";
			}
			ans += "aunt";
		}

		// case 3: cousins (????)
		// case 4: not related
		if (ans.equals(""))
			out.println("COUSINS");
		else
			out.println(cowOne + " is the " + ans + " of " + cowTwo);

		out.close();
	}

	public static String findMom(String key, String[][] relations) {
		for (int i = 0; i < relations.length; i++) {
			if (relations[i][1].equals(key))
				return relations[i][0];
		}
		return "!";
	}

	public static String[] findSiblings(String mom, String key, String[][] relations) {
		ArrayList<String> returned = new ArrayList<String>();
		for (int i = 0; i < relations.length; i++) {
			if (mom.equals(relations[i][0]) && !key.equals(relations[i][1])) {
				returned.add(relations[i][1]);
			}
		}
		String[] actual = new String[returned.size()];
		for (int f = 0; f < returned.size(); f++) {
			actual[f] = returned.get(f);
		}
		return actual;
	}

	public static boolean isPart(String[] i, String key) {
		for (int k = 0; k < i.length; k++) {
			if (i[k].equals(key))
				return true;
		}
		return false;
	}
}
