package classes;

public class Main {
	public static void main(String[] args) {
		SolutionV2 sol = new SolutionV2();
		int[][] matrix = {{1,0,1},{0,-2,3}};
		int k=2;
		
		sol.maxSumSubmatrix(matrix, k);
	}
}
