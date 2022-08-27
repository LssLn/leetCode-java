package classes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	List<RectangleSum> rectangles = new ArrayList<>();
        // I have a rectangle m x n and an integer K			m = rows		n = columns
    	int m = matrix.length; 		//rows
    	int n = matrix[0].length;	//cols
    	
		System.out.println("Input:");
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			System.out.print(matrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
        // The sum inside the target rectangle has to be
        //	-	< K
        // 	-	> than all the other possible sums inside the matrix
        
        // Exec the sums of all the rectangles inside the objects rectangleSum
        // store their info:	
        // 	-	which rows and columns corresponds to the rectangle 
        //			(ie. In the example 1 figure the blue rectangle has rows 0,1	columns 1,2
        //			In case there is only 1 row or column, the same data will be repeated for all the indexes
    	//	-	their sum
    	
    	// the matrix needs to be slided, starting from 1 index, increasing the other index after each slide
    	for(int row=0;row<m;row++) { 		// single row
    		for(int col_start=0;col_start<n;col_start++) {	//col = col_start
    	    	Integer sum=0;
    			for(int col_end=0;col_end<row;col_end++) {	//column increases, from col_start to col_end, which is <= row
    				Integer[] row_array = {row,row};
    				Integer[] col_array = {col_start,col_end};
    				int diff = col_end-col_start;
    				sum += matrix[row][col_start];
    				for(int i=1;i<diff;i++) { //diff-1 elements to sum to col_start and col_end
    					sum += matrix[row][col_start]+i;
    				}
    				sum += matrix[row][col_end];
    				
    				System.out.println(sum);
    				if(sum<k) {
        				RectangleSum rect = new RectangleSum(row_array,col_array,sum);
        				rectangles.add(rect);
    				}
    				
    			}
    			
    			
    		}
    	}
    	
    	for(RectangleSum r:rectangles) {
    		System.out.println(" 	#	rows "+r.getRows()+" columns "+r.getColumns()+". Sum: "+r.getSum());
    	}
    	
    	return 0;
    }
}
