import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> pascalTriangle = new ArrayList<>(new ArrayList<>(1));
    	pascalTriangle.add(Arrays.asList(1)); // first row

    	//cycling rows
    	for(int row=1;row<=numRows;row++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> pastRow = pascalTriangle.get(row-1);
            currentRow.add(1); // the row begins with a 1

    		//cycling columns
    		for(int col=1;col<=pastRow.size();col++) { //pastRow has the first and last values 1
    			currentRow.add(pastRow.get(col-1) + pastRow.get(col));
    		}
            currentRow.add(1); // the row ends with a 1
            pascalTriangle.add(currentRow);
    	}
    	
    	return pascalTriangle;
    }
}
