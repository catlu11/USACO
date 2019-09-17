package USACO;
import java.util.ArrayList;

// https://www.hackerrank.com/challenges/save-humanity

public class Virus {
	public void findCase(String patient, String virus) {
		if (virus.length() > patient.length()) {
			System.out.println("No Match!");
			return;
		}

		ArrayList<Integer> indices = new ArrayList<Integer>();
		String temp = "";
		int mismatch = 0;

		for (int i = 0; virus.length() + i < patient.length(); i++) {
			temp = patient.substring(i, virus.length() + i);
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) != virus.charAt(j)) {
					mismatch++;
				}
			}
			if (mismatch == 1 || mismatch == 0) {
				indices.add(i);
			}
			mismatch = 0;
		}

		String result = "";

		for (int k = 0; k < indices.size(); k++) {
			result = result + Integer.toString(indices.get(k)) + " ";
		}

		if (indices.size() == 0) {
			System.out.println("No Match!");
		} else {
			System.out.println(result);
		}
	}

	// public static void main(String[] args) {
	// Virus virus = new Virus();
	// virus.findCase("ccc", "bb");
	// }
}
