import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 
Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

public class Solution {
    public List<String> letterCombinations(String digits) {    	
    	List<String> resultList = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc"); map.put(3, "def"); map.put(4, "ghi");map.put(5, "jkl"); map.put(6, "mno"); map.put(7, "pqrs");map.put(8, "tuv"); map.put(9, "wxyz");
    	
    	if(digits.length()==0) {return resultList;}
    	
    	System.out.println("n results: "+countSolutions(digits, map));
    	
    	//without it can't store any data as it needs something to begin with
    	resultList.add("");
    	//for each digit in input
    	for(int i=0; i<digits.length(); i++) {
    		//extracts the letters corresponding to that digit
    		Integer digit = Integer.parseInt(""+digits.charAt(i));
    		String letters = map.get(digit);
    		//cycle the resultList, replacing each element with the new combination.
    		int size = resultList.size();
    		for(int j=0; j<size; j++) {
    			String current = resultList.remove(0);
    			for(int k=0; k<letters.length(); k++) {
    				resultList.add(current+letters.charAt(k));
    			}
    		}
    	}
    	
    	return resultList;
    }
    
    public Integer countSolutions(String digits, HashMap<Integer, String> map) {
    	Integer nresults = 1;
    	for(int i=0;i<digits.length();i++) {
    		String letters = map.get(Integer.parseInt(""+digits.charAt(i)));
    		nresults *= letters.length();
    	}
    	return nresults;
    }
    
    /*
     * 
     */
}
