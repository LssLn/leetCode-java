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
//    		int columnStart = 1;
    		
    		//2 cycles to do direction sx and dx shifting
    		for(int directionColumn = 0; directionColumn<2; directionColumn++) {
        		int columnStart = 1;
    			if(directionColumn == 0) {	// Column: Dx shifting
    	    		for(int icolumn=0;icolumn<matrixColumns;icolumn++) { //maybe columnIterations instead of matrixColumns?
    	    			for(int irow=1;irow<=nIterations;irow++) { // i = number of rows we are considering for this cycle
    	            		System.out.println(ANSI_CYAN+" 		ITERATION "+irow+ANSI_PURPLE+"\tCOLUMN SHIFT - DX DIRECTION "+(columnStart-1)+ANSI_WHITE);
    	            		//ANALYZING
    	        			System.out.println("\t\t row "+rowCounterFixed+", analyzing row: "+ANSI_CYAN+(rowCounterFixed-1+irow)+ANSI_WHITE);
    	        			//selected row doing the scanning of all the combinations with all the columns
    	        			int sumRow = 0;
    	        			//Added nullIterationFlag
    	        			//if the current iteration has 0 elements the flag won't be changed, in order to avoid that sumRow (initialied at 0 but never changed) is added to sumSet
    	        			boolean nullIterationFlag = true;
    	        			System.out.print("\t\t");
    	        			for(int columnCounter = 0; columnCounter<matrixColumns;columnCounter++) {
//    	                		int columnCounterFixed = columnCounter + 1; // = forColumnIncrIndex ;
//    	        				columnIterations--;
    	        				try {
    	            				if((columnCounter+columnStart-1)<=(columnIterations)) { //avoiding ArrayIndexOutOfBoundsException
    	            					nullIterationFlag = false;
    	            					
    	            					System.out.print("\tcol "+(columnCounter+columnStart) + " ["+ANSI_YELLOW+matrix[rowStart-1+irow-1][columnCounter+columnStart-1]+ANSI_WHITE+"] ");   				
    	                        		if(matrix[rowStart-1+irow-1][columnCounter+columnStart-1]<=k) {
    	                        			sumSet.add(matrix[rowStart-1+irow-1][columnCounter+columnStart-1]);
    	                        		}
    	                        		sumRow+=matrix[rowStart-1+irow-1][columnCounter+columnStart-1];
    	                        		if(sumRow<=k) {
    	                        			sumSet.add(sumRow);
    	                        		}
    	            				}
    	        				}catch(Exception e) {
    	        					//ArrayIndexOutOfBounds
    	        					System.out.print("Exception thrown: "+e);
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
//    	        				if(!nullIterationFlag) {
//    	        					sumSet.add(iterationSum);
//    	        				}
    	        				System.out.println(" row sum ==> "+ANSI_GREEN+sumRow+ANSI_WHITE);
    	        				if(iterationSum>k) {
    	            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_RED+iterationSum+ANSI_WHITE);
    	            			}else {
    	            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_GREEN+iterationSum+ANSI_WHITE);
    	            				if(!nullIterationFlag) {
    	            					sumSet.add(iterationSum);
    	            				}
    	            			}
    	        			}
    	        		}
    	    			//skipping to the next column
    	    			columnStart++;
    	    			iterationSum=0;
    	    		}
    			}
    			
    			if(directionColumn == 1) {	// Column: Sx shifting
    	    		for(int icolumn=0;icolumn<matrixColumns;icolumn++) {
    	    			for(int irow=1;irow<=nIterations;irow++) { // i = number of rows we are considering for this cycle
    	            		System.out.println(ANSI_CYAN+" 		ITERATION "+irow+ANSI_PURPLE+"\tCOLUMN SHIFT - SX DIRECTION "+(columnStart-1)+ANSI_WHITE);
    	            		//ANALYZING
    	        			System.out.println("\t\t row "+rowCounterFixed+", analyzing row: "+ANSI_CYAN+(rowCounterFixed-1+irow)+ANSI_WHITE);
    	        			//selected row doing the scanning of all the combinations with all the columns
    	        			int sumRow = 0;
    	        			//Added nullIterationFlag
    	        			//if the current iteration has 0 elements the flag won't be changed, in order to avoid that sumRow (initialied at 0 but never changed) is added to sumSet
    	        			boolean nullIterationFlag = true;
    	        			System.out.print("\t\t");
    	        			for(int columnCounter = matrixColumns-1; columnCounter>=0;columnCounter--) {
//    	                		int columnCounterFixed = columnCounter + 1; // = forColumnIncrIndex ;
//    	        				columnIterations--;
    	        				try {
    	            				if((columnCounter-columnStart)>=0) { //avoiding ArrayIndexOutOfBoundsException
    	            					nullIterationFlag = false;
    	            					
    	            					System.out.print("\tcol "+(columnCounter-columnStart) + " ["+ANSI_YELLOW+matrix[rowStart-1+irow-1][columnCounter-columnStart]+ANSI_WHITE+"] ");   				
    	                        		if(matrix[rowStart-1+irow-1][columnCounter-columnStart]<=k) {
    	                        			sumSet.add(matrix[rowStart-1+irow-1][columnCounter-columnStart]);
    	                        		}
    	                        		sumRow+=matrix[rowStart-1+irow-1][columnCounter-columnStart];
    	                        		if(sumRow<=k) {
    	                        			sumSet.add(sumRow);
    	                        		}
    	            				}
    	        				}catch(Exception e) {
    	        					//ArrayIndexOutOfBounds
    	        					System.out.print("Exception thrown: "+e);
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
    	            				if(!nullIterationFlag) {
    	            					sumSet.add(iterationSum);
    	            				}
    	            			}
    	        			}else {
//    	        				if(!nullIterationFlag) {
//    	        					sumSet.add(iterationSum);
//    	        				}
    	        				System.out.println(" row sum ==> "+ANSI_GREEN+sumRow+ANSI_WHITE);
    	        				if(iterationSum>k) {
    	            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_RED+iterationSum+ANSI_WHITE);
    	            			}else {
    	            				System.out.println("\t\t\t\t\t\titeration sum = "+ANSI_GREEN+iterationSum+ANSI_WHITE);
    	            				if(!nullIterationFlag) {
    	            					sumSet.add(iterationSum);
    	            				}
    	            			}
    	        			}
    	        		}
    	    			//skipping to the next column
    	    			columnStart++;
    	    			iterationSum=0;
    	    		}
    			}
    		}
    		//column direction sx shifting 		|| and has columnStart reversed
    		//column direction dx shifting

    		//skipping to next row
    		rowStart++;
    	}
    	//calculating the closer to k
    	for(Integer n:sumSet) {
    		if(n>sum && n<=k) {
    			sum=n;
    		}
    	}
    	return sum;
    }   
}
