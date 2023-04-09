import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> pascalTriangle = new ArrayList<>(new ArrayList<>(1));
    	pascalTriangle.add(Arrays.asList(1)); // first row

    	//cycling rows
    	for(int row=1;row<=numRows-1;row++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> pastRow = pascalTriangle.get(row-1);
            
            currentRow.add(1); // the row begins with a 1
    		//cycling columns
            //pastRow has the first and last values 1, so i exclude both (1th with col=1 and the last with col<=pastRow.size()-1
    		for(int col=1;col<=pastRow.size()-1;col++) {
    			currentRow.add(pastRow.get(col-1) + pastRow.get(col));
    		}
            currentRow.add(1); // the row ends with a 1
            
            pascalTriangle.add(currentRow);
    	}
    	return pascalTriangle;
    }
}
