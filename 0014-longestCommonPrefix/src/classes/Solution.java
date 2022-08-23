package classes;

public class Solution {
	 public String longestCommonPrefix(String[] strs) {
	        int minimumLength=strs[0].length();
	        //Cycling string array - determining smaller string's lenght 
	        for(String s:strs){
	            if(s.length() < minimumLength) {
	            	minimumLength = s.length();
	            }
	        }
	        System.out.println(minimumLength);
	        return "";
	    }
}
