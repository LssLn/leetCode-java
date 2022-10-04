package classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	int matrixRows = matrix.length;	// N
    	int matrixColumns = matrix[0].length;	// M
    	//given an MxN matrix		=	M columns	N rows
    	
    	//printing matrix 
    	System.out.println("Matrix in input: \nSize = "+matrixRows+" rows   |   "+matrixColumns+" column\n");
    	for(int i=0;i<matrixRows;i++) { // N cycles
    		System.out.print("  ");
    		for(int j=0;j<matrixColumns;j++) {		// M cycles
    			System.out.print(matrix[i][j]+"\t");
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
    		System.out.println("\n\n - row number : "+rowCounterFixed);

    		int nIterations = matrixRows+1-rowStart;
    		//N ITERATIONS
    		System.out.println(" 	there are "+nIterations+" iterations for this row");
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
            		System.out.println(" 		ITERATION "+irow+"\tCOLUMN SHIFT "+(columnStart-1));
            		//ANALYZING
        			System.out.println("\t\t row "+rowCounterFixed+", analyzing row: "+(rowCounterFixed-1+irow));
        			//selected row doing the scanning of all the combinations with all the columns
        			int sumRow = 0;
        			System.out.print("\t\t");
        			for(int columnCounter = 0; columnCounter<matrixColumns;columnCounter++) {
//                		int columnCounterFixed = columnCounter + 1; // = forColumnIncrIndex ;
//        				columnIterations--;
        				try {
            				if((columnCounter+columnStart-1)<=(columnIterations)) { //avoiding ArrayIndexOutOfBoundsException
            					System.out.print("\tcol "+(columnCounter+columnStart) + " ["+matrix[rowStart-1+irow-1][columnCounter+columnStart-1]+"] ");   				
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
            			System.out.print(" row sum = "+sumRow);
            			if(iterationSum>k) {
            				System.out.println("\t\t\t\t\t\titeration sum = "+iterationSum);
            			}else {
            				System.out.println("\t\t\t\t\t\titeration sum = "+iterationSum);
            			}
        			}else {
        				sumSet.add(iterationSum);
        				System.out.println(" row sum ==> "+sumRow);
        				if(iterationSum>k) {
            				System.out.println("\t\t\t\t\t\titeration sum = "+iterationSum);
            			}else {
            				System.out.println("\t\t\t\t\t\titeration sum = "+iterationSum);
            			}
        			}
        		}
    			//skipping to the next column
    			columnStart++;
    			iterationSum=0;
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
}
