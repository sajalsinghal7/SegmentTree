package implementation;

public class MainHandler {
	public static void main(String[] args) {
		int[] input = {5,2,1,3,4,6,7,9,8,3};
		// Height of segment tree 
	    double x = Math.ceil(Math.log(input.length))+1; 
	  
	    // Maximum size of segment tree 
	    int max_size = 2 * (int)Math.pow(2, x) - 1;
		int[] tree = new int[max_size];
		System.out.println(createSegmentTree(input,tree,0,input.length-1,0));
	}
	//NR->Node range
	//QR->Query Range
	//UQR-> Update Query Range
	
	
	// Create A segment Tree
	public static int createSegmentTree(int[] input, int[] tree, int start, int end,int head) {
		if (start==end) {
			tree[head] = input[start];
			return input[start];
		}
		int mid = (start + end) / 2;
		int left = createSegmentTree(input, tree, start, mid,(head*2)+1);
		int right = createSegmentTree(input, tree, mid+1, end, (head*2)+2);
		tree[head] = left + right;
		return tree[head];
	}
	//Find Result of a range
	//Update the Tree
}
