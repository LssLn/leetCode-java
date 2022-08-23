package classes;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	 public String longestCommonPrefix(String[] strs) {
	        int minimumLength=strs[0].length();
	        boolean found=false;
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
	        
	        
//	        int count=0;
//	        while(!found) {
//	        	count=0;
//		        //substring() - 1st param cannot be equal or smaller than 2nd param, else it Throws:IndexOutOfBoundsException
//	        	if(minimumLength > 0) {
//	        		//if not all ss elements are equals, prefix is not common
//		        	for(int j=0;j<strs.length;j++) {
//			        	//confronting each element of substrings ss
//			        	for(int k=0;k<strs.length;k++) {
//			        		//with eachothers
//			        		if(subStrs.get(j).equals(subStrs.get(k))) {
//			        			count++;
//			        		}
//			        	}
//		        	}
//			        if(count==strs.length) {
//		        			prefix = subStrs.get(0);
//			        }else {
//				       	minimumLength -= 1;
//				       	subStrs.removeAll(subStrs);
//			        }
//		        }
//	        }
	    }
}
