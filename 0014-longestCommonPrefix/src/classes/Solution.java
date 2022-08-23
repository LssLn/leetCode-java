package classes;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	 public String longestCommonPrefix(String[] strs) {
	        int minimumLength=strs[0].length();
	        String prefix = "";
	        
	        //Cycling string array - determining smaller string's lenght 
	        for(String s:strs){
	            if(s.length() < minimumLength) {
	            	minimumLength = s.length();
	            }
	        }
	        System.out.println(minimumLength);
	        
	        while(true) {
	        	//Get the longest common prefix
		        Set<String> subStrs = new HashSet<>();
		        //Getting the substr, with dimension = minimumLength, of every string into the string array
		        for(String s: strs) {
		        	subStrs.add(s.substring(0, minimumLength));
		        }
		        
		        if(subStrs.size()>1) {
		        	//subStrings are not the same
			       	minimumLength -= 1;
		        }else {
		        	for(String s : strs) {
		        		//retrieving longest common prefix
		        		if(subStrs.contains(s.substring(0, minimumLength))) {
		        			prefix = s.substring(0, minimumLength);
		        			return prefix;
		        		}
		        	}
		        }
	        }
	    }
}
