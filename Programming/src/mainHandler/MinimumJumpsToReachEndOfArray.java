package mainHandler;

public class MinimumJumpsToReachEndOfArray {
	public static void execute() {
		int[] input = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] jumpCount = new int[input.length];
		int[] jumpedFrom = new int[input.length];
		computeJumps(input,jumpCount,jumpedFrom);
		printJumpsForIndex(input.length -1, jumpedFrom);
	}
	public static void computeJumps(int[] input, int[] jumpCount, int[] jumpedFrom) {
		int parent, reference;
		int len = input.length;
		for(reference = 1; reference < len; reference++) {
			for(parent = 0; parent < reference; parent++) {
				int parentElement = input[parent];
				if(reference <= (parent + parentElement)) {
					if(jumpCount[reference] == 0) {
						jumpCount[reference] = 1;
						jumpedFrom[reference] = parent;
					} else {
						if(jumpCount[parent] + 1 < jumpCount[reference]) {
							jumpCount[reference] = jumpCount[parent] + 1;
							jumpedFrom[reference] = parent;
						}
					}
				}
			}
		}
	}
	public static void printJumpsForIndex(int index, int[] jumpedFrom) {
		while(index > 0) {
			System.out.print(index + "\t");
			index = jumpedFrom[index];
		}
		System.out.print(index);
	}
}
