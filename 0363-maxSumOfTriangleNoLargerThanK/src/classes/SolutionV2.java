package classes;

import java.util.HashMap;
import java.util.Map;

public class SolutionV2 {
	public static String ANSI_GREEN="\033[92m"; // green = grass
	public static String ANSI_RED="\033[31m";
	public static String ANSI_YELLOW="\033[33m";
	public static String ANSI_WHITE="\033[37m";
	public static String ANSI_MGNT="\033[36m";
	public static String ANSI_BRIGHT_YELLOW="\033[93m";
	public static String ANSI_BLUE = "\u001B[34m";
	public static String ANSI_PURPLE = "\u001B[35m";
	public static String ANSI_CYAN = "\u001B[36m";
	
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	//given an MxN matrix		=	M columns	N rows
    	int sum = 0;
    	int matrixRows = matrix.length;	// N
    	int matrixColumns = matrix[0].length;	// M
    	
    	System.out.println("Matrix in input: \nSize = "+matrixRows+" rows   |   "+matrixColumns+" column\n");
    	for(int i=0;i<matrixRows;i++) { // N cycles
    		System.out.print("  ");
    		for(int j=0;j<matrixColumns;j++) {		// M cycles
    			System.out.print(ANSI_GREEN+matrix[i][j]+"\t"+ANSI_WHITE);
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
    		System.out.println("\n\n - row number : "+ANSI_RED+rowCounterFixed+ANSI_WHITE);

    		//MULTIROWS
    		int rowStart = 1; //will be incremented after each row is finished (each row = N combinations)
    		int nIterations = matrixRows+1-rowStart;
    		System.out.println(" 	there are "+ANSI_CYAN+nIterations+ANSI_WHITE+" iterations for this row");
    		System.out.println(" 	- going from row number "+rowCounterFixed+ " to row number "+(rowCounter-1+nIterations));
    		int iterationSum=0;
    		for(int irow=1;irow<=nIterations;irow++) { // i = number of rows we are considering for this cycle
        		System.out.println(ANSI_CYAN+" 		ITERATION "+irow+ANSI_WHITE);

    			System.out.println(" 		- row "+rowCounterFixed+", analyzing row: "+(rowCounterFixed-1+irow));
    			//selected row doing the scanning of all the combinations with all the columns
    			int sumRow = 0;
    			//translation for the column
    			System.out.print(" 			");
    			for(int columnCounter = 0; columnCounter <matrixColumns;columnCounter++) {
            		int columnCounterFixed = columnCounter + 1; // used with the matrix
//    				System.out.print(" column "+columnCounterFixed);
            		sumRow+=matrix[irow-1][columnCounterFixed-1];
            		
    				System.out.print(" ["+matrix[irow-1][columnCounterFixed-1]+"] ");
    			}
    			iterationSum += sumRow;
    			if(iterationSum > k) {
        			System.out.println(" row sum ==> "+sumRow+ANSI_RED+"		iteration sum = "+iterationSum+ANSI_WHITE);
    			}else {
    				sum=iterationSum;
        			System.out.println(" row sum ==> "+sumRow+ANSI_GREEN+"		iteration sum = "+iterationSum+ANSI_WHITE);
    			}
    		}
    		rowStart++;
    	}
    	
    	return sum;
    }
}
