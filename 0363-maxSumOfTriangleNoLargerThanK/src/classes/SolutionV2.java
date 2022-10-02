package classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    	int matrixRows = matrix.length;	// N
    	int matrixColumns = matrix[0].length;	// M
    	//given an MxN matrix		=	M columns	N rows
    	
    	//printing matrix 
    	System.out.println("Matrix in input: \nSize = "+matrixRows+" rows   |   "+matrixColumns+" column\n");
    	for(int i=0;i<matrixRows;i++) { // N cycles
    		System.out.print("  ");
    		for(int j=0;j<matrixColumns;j++) {		// M cycles
    			System.out.print(ANSI_GREEN+matrix[i][j]+"\t"+ANSI_WHITE);
    		}
    		System.out.println();
    	}
    	
    	int returnVRows = calcMatrixSumRows(matrix,k,matrixRows,matrixColumns);
//    	int returnVColumns = calcMatrixSumColumns(matrix,k,matrixRows,matrixColumns);
//    	System.out.println(" {[( "+returnVRows+" |||  "+returnVColumns+" )]}");
    	return returnVRows;
    }
    
    public int calcMatrixSumRows(int[][] matrix, int k, int matrixRows, int matrixColumns) {
    	int sum = -100001;	//k is given, by constraints, in the range -105 <= k <= 105. sum is initialized to always be < k
    	Set<Integer> sumSet = new HashSet<>();    	

    	// for a given matrix NxM we will have, for each row, N combinations and N-1 iterations
    	// analyzing rows
		int rowStart = 1; //will be incremented after each row is finished (each row = N combinations)
    	for(int rowCounter = 0; rowCounter < matrixRows; rowCounter ++) {
    		//first cycle
    		int rowCounterFixed = rowCounter + 1; // used with the matrix
    		System.out.println("\n\n - row number : "+ANSI_RED+rowCounterFixed+ANSI_WHITE);

    		int nIterations = matrixRows+1-rowStart;
    		//N ITERATIONS
    		System.out.println(" 	there are "+ANSI_CYAN+nIterations+ANSI_WHITE+" iterations for this row");
    		System.out.println(" 	- going from row number "+rowCounterFixed+ " to row number "+(rowCounter-1+nIterations));
    		int iterationSum=0;
    		
    		//setting params for multicolumn, used inside the irow for
    		int columnIterations = matrixColumns - 1; // - 1?
    		//another for in which we decrease the number of columns, inside the irow for
    		//the variable of this for cycle is columnCounterFixed = another variable set to 0 but incrementing each for
    		int columnStart = 1;
    						//then we need to do this but with column indexes reversed to do the clockverse of column scan --> useless
    		for(int icolumn=0;icolumn<matrixColumns;icolumn++) { //maybe columnIterations instead of matrixColumns?
    			for(int irow=1;irow<=nIterations;irow++) { // i = number of rows we are considering for this cycle
            		System.out.println(ANSI_CYAN+" 		ITERATION "+irow+ANSI_WHITE);
            		//ANALYZING
        			System.out.println("\t\trow "+rowCounterFixed+", analyzing row: "+ANSI_CYAN+(rowCounterFixed-1+irow)+ANSI_WHITE);
        			//selected row doing the scanning of all the combinations with all the columns
        			int sumRow = 0;
        			System.out.print("\t\t");
        			for(int columnCounter = 0; columnCounter<matrixColumns;columnCounter++) {
//                		int columnCounterFixed = columnCounter + 1; // = forColumnIncrIndex ;
//        				columnIterations--;
        				if((columnCounter+columnStart-1)<=(matrixColumns-columnStart)) { //avoiding column index out of bounds
        					System.out.print(" column "+(columnCounter+columnStart) + " ["+ANSI_YELLOW+matrix[rowStart-1+irow-1][columnCounter+columnStart-1]+ANSI_WHITE+"] ");   				
                    		if(matrix[rowStart-1+irow-1][columnCounter+columnStart-1]<=k) {
                    			sumSet.add(matrix[rowStart-1+irow-1][columnCounter+columnStart-1]);
                    		}
                    		sumRow+=matrix[rowStart-1+irow-1][columnCounter+columnStart-1];
                    		if(sumRow<=k) {
                    			sumSet.add(sumRow);
                    		}
        				}
        				
        			}
        			//row sum = sum of current iteration (row)
        			//iteration sum = sum of current iteration (row) and previous iterations
        			iterationSum += sumRow;
        			if(sumRow > k) {
            			System.out.print(" row sum = "+ANSI_RED+sumRow+ANSI_WHITE);
            			if(iterationSum>k) {
            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_RED+iterationSum+ANSI_WHITE);
            			}else {
            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_GREEN+iterationSum+ANSI_WHITE);
            			}
        			}else {
        				sumSet.add(iterationSum);
        				System.out.println(" row sum ==> "+ANSI_GREEN+sumRow+ANSI_WHITE);
        				if(iterationSum>k) {
            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_RED+iterationSum+ANSI_WHITE);
            			}else {
            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_GREEN+iterationSum+ANSI_WHITE);
            			}
        			}
        		}
    			//skipping to the next column
    			columnStart++;
    		}
    		//skipping to next row
    		rowStart++; //sliding row of one
    		//forColumnIncrIndex++;
    	}
    	//calculating the closer to k
    	for(Integer n:sumSet) {
    		if(n>sum && n<=k) {
    			sum=n;
    		}
    	}
    	return sum;
    	
    }
    
    // TODO: Solve out of bounds for columns 
    /*
        public int calcMatrixSumColumns(int[][] matrix, int k, int matrixRows, int matrixColumns) {
        	int sum = -100001;	//k is given, by constraints, in the range -105 <= k <= 105. sum is initialized to always be < k
        	Set<Integer> sumSet = new HashSet<>();

        	// for a given matrix NxM we will have, for each column, N combinations and N-1 iterations
        	// analyzing rows
    		int columnStart = 1; //will be incremented after each column is finished (each column = M combinations)
        	for(int columnCounter = 0; columnCounter < matrixColumns; columnCounter ++) {
        		//first cycle
        		int columnCounterFixed = columnCounter + 1; // used with the matrix
        		System.out.println("\n\n - column number : "+ANSI_RED+columnCounterFixed+ANSI_WHITE);

        		//MULTICOLUMNS
        		int nIterations = matrixColumns+1-columnStart;
        		System.out.println(" 	there are "+ANSI_CYAN+nIterations+ANSI_WHITE+" iterations for this column");
        		System.out.println(" 	- going from column number "+columnCounterFixed+ " to column number "+(columnCounter-1+nIterations));
        		int iterationSum=0;
        		for(int icolumn=1;icolumn<=nIterations;icolumn++) { // i = number of columns we are considering for this cycle
            		System.out.println(ANSI_CYAN+" 		ITERATION "+icolumn+ANSI_WHITE);

        			System.out.println(" 		- column "+columnCounterFixed+", analyzing column: "+(columnCounterFixed-1+icolumn));
        			//selected row doing the scanning of all the combinations with all the columns
        			int sumColumn = 0;
        			//translation for the row
        			System.out.print(" 			");
        			for(int rowCounter = 0; rowCounter <matrixRows;rowCounter++) {
                		int rowCounterFixed = rowCounter + 1; // used with the matrix
//        				System.out.print(" row "+rowCounterFixed);
                		if(matrix[rowCounterFixed-1][icolumn-1]<=k) { //swap?
                			sumSet.add(matrix[icolumn-1][rowCounterFixed-1]);
                		}
                		sumColumn+=matrix[icolumn-1][rowCounterFixed-1];
                		if(sumColumn<=k) {
                			sumSet.add(sumColumn);
                		}
        				System.out.print(" ["+matrix[icolumn-1][rowCounterFixed-1]+"] ");
        			}
        			iterationSum += sumColumn;
        			if(iterationSum > k) {
            			System.out.println(" column sum ==> "+sumColumn+ANSI_RED+"		iteration sum = "+iterationSum+ANSI_WHITE);
        			}else {
        				sumSet.add(iterationSum);
        				System.out.println(" column sum ==> "+sumColumn+ANSI_GREEN+"		iteration sum = "+iterationSum+ANSI_WHITE);
        			}
        		}
        		columnStart++;
        	}
        	//calculating the closer to k
        	for(Integer n:sumSet) {
        		if(n>sum && n<=k) {
        			sum=n;
        		}
        	}
        	return sum;
        	
        }
   */
        
}
