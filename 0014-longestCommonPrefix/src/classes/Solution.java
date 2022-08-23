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
	        
	        //Get the longest common prefix
	        
	        //Getting the substr, with dimension = minimumLength, of every string into the string array
	        for(String s: strs) {
	        	String ss = s.substring(0, minimumLength);
		        System.out.println(ss);

	        }

	        return "";
	    }
}
