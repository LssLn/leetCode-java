package classes;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = {{1,0,1},{0,-2,3}};
		int k=0;
		
		sol.maxSumSubmatrix(matrix, k);
	}
}
