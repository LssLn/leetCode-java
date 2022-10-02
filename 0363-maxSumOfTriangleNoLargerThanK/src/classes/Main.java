package classes;

public class Main {
	public static void main(String[] args) {
		SolutionV2 sol = new SolutionV2();
		int[][] matrix = {{1,0,1},{0,-2,3}};
		int k=2;
		int returnV =0;
		
//		returnV = sol.maxSumSubmatrix(matrix, k); //2
//		System.out.println("			RESULT:: "+returnV);
		
//		matrix= new int[][]{{2,2,-1}};
//		k=3;
//		returnV = sol.maxSumSubmatrix(matrix, k); //3
//		System.out.println("			RESULT:: "+returnV);
//
//		matrix= new int[][]{{2,2,-1}};
//		k=2;
//		returnV = sol.maxSumSubmatrix(matrix, k); //2
//		System.out.println("			RESULT:: "+returnV);
//		
//		matrix= new int[][]{{2,2,-1}};
//		k=0;
//		returnV = sol.maxSumSubmatrix(matrix, k); //2
//		System.out.println("			RESULT:: "+returnV);
		
		matrix= new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
		k=10;
		returnV = sol.maxSumSubmatrix(matrix, k); //10
		System.out.println("	\nRESULT:: "+returnV);
//		
//		matrix= new int[][]{{5,-3,5},{-4,-4,1},{-3,4,5},{4,5,-4}}; //{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4} ^-1
//		k=10;
//		returnV = sol.maxSumSubmatrix(matrix, k); //10
//		System.out.println("			RESULT:: "+returnV);
	}
}
