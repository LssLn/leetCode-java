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
        map.put(2, "abc"); map.put(3, "def"); map.put(4, "ghi");
    	map.put(5, "jkl"); map.put(6, "mno"); map.put(7, "pqrs");
    	map.put(8, "tuv"); map.put(9, "wxyz");
    	
//    	System.out.println("digits: "+digits);
    	
    	for(int i=0;i<digits.length();i++) {
    		Integer digitOne = Integer.parseInt(""+digits.charAt(i));
    		String lettersOne = map.get(digitOne);
    		for(int k=0;k<digits.length();k++) {
        		Integer digitTwo = Integer.parseInt(""+digits.charAt(k));
        		String lettersTwo = map.get(digitTwo);
        		if(digitOne != digitTwo) {
        			for(int counter1=0;counter1<lettersOne.length();counter1++) {
            			for(int counter2=0;counter2<lettersTwo.length();counter2++) {
            				String str = ""+lettersOne.charAt(counter1)+lettersTwo.charAt(counter2);
            				resultList.add(str);
            			}
            		}
        		}
    		}
    	}
    	
    	return resultList;
    }
}
