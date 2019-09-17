package USACO;
import java.util.ArrayList;

public class PerfectNum {

	public ArrayList<Integer> findFactors(int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();

		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}

	public void firstFourPerf() {
		int count = 0;

		for (int i = 1; count < 4; i++) {
			int tempSum = 0;
			ArrayList<Integer> dFactors = findFactors(i);
			for (int j = 0; j < dFactors.size(); j++) {
				tempSum = tempSum + dFactors.get(j);
			}
			if (tempSum == i) {
				count++;
				System.out.println(i);
			}
		}
	}

	// public static void main(String[] args) {
	// PerfectNum test = new PerfectNum();
	// test.firstFourPerf();
	// }
}
