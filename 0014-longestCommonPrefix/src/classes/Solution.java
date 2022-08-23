package classes;

import java.util.ArrayList;

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
	        
	        //Get the longest common prefix
	        
	        ArrayList<String> ss = new ArrayList<>();
	        int i=0;
	        //Getting the substr, with dimension = minimumLength, of every string into the string array
	        for(String s: strs) {
	        	ss.add(s.substring(0, minimumLength));
		        System.out.println(ss.get(i));
		        i++;
	        }
	        
	        
	        //while(!found) {
	        	
		        //substring() - 1st param cannot be equal or smaller than 2nd param, else it Throws:IndexOutOfBoundsException
	        	if(minimumLength > 0) {
	        		//if not all ss elements are equals, prefix is not common
		        	for(int j=0;j<strs.length;j++) {
			        	//confronting each element of substrings ss
			        	for(int k=0;k<strs.length;k++) {
			        		//with eachothers
			        		if(ss.get(j).equals(ss.get(k))) {
			        			found=true;
			        			prefix = ss.get(j);
			        		}else {
			        			found=false;
			        		}
			        	}
			        }
		        	
		    //   	minimumLength -= 1;
		        }
	        //}
	  
	        return prefix;
	    }
}
