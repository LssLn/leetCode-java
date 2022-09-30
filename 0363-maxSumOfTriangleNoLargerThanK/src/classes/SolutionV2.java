package classes;

import java.util.HashMap;
import java.util.Map;

public class SolutionV2 {
	
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	//given an MxN matrix		=	M columns	N rows
    	int matrixRows = matrix.length;	// N
    	int matrixColumns = matrix[0].length;	// M
    	
    	System.out.println("Matrix in input: \nSize = "+matrixRows+" rows   |   "+matrixColumns+" column\n");
    	for(int i=0;i<matrixRows;i++) { // N cycles
    		System.out.print("  ");
    		for(int j=0;j<matrixColumns;j++) {		// M cycles
    			System.out.print(matrix[i][j]+"\t");
    		}
    		System.out.println();
    	}
    	
    	/*	we need to store these data:
    	 * 		- info about which rectangle we are examining (row, row, col, col)
    	 * 		- the sum of this rectangle
    	 *  This can be accomplished through an HashMap<Integer[],Integer>
    	 */
    	Map<Integer[],Integer> dataMap = new HashMap<>();
    	// for a given matrix NxM we will have, for each row, N combinations and N-1 iterations
    	
    	// analyzing rows
    	for(int rowCounter = 0; rowCounter < matrixRows; rowCounter ++) {
    		//first cycle
    		int rowCounterFixed = rowCounter + 1; // used with the matrix
    		for(int columnCounter = 0; columnCounter < matrixColumns ; columnCounter++) {
        		int columnCounterFixed = columnCounter + 1; // used with the matrix
        		
        		//calculating math graph
        		
        		
        		//adding to dataMap only if sum < K
    		}
    	}
    	
    	return 0;
    }
}
