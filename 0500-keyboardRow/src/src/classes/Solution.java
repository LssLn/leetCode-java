package src.classes;

public class Solution {
	public String[] findWords(String[] words) {
		//init words fitting, maximum size is equal to words
		String[] result= new String[words.length];
		int resultCounter=0;
		String row1 = "qwertyuiop";
		String row2 = "asdfghjkl";
		String row3 = "zxcvbnm";
		boolean row1Matched = false, row2Matched = false, row3Matched=false;
		
		//iterating words array
		for(String word:words) {
			System.out.println("\nWord: "+word+" :");
			//iterating each word characters
		     for(int i=0;i<word.length();i++) {
		    	 String wordChar = "" + word.charAt(i);
		    	 System.out.print(" "+wordChar);
		    	 //iterating row1 characters
		    	 for(int j=0;j<row1.length();j++) {
		    		 String row1Char = "" + row1.charAt(j);
		    		 if(wordChar.equals(row1Char)) {
		    			 //if this word is equal to one of row1, set row1Matched flag to true
		    			 row1Matched=true;
		    		 }
		    	 }
		    	 //iterating row2 characters
		    	 for(int j=0;j<row2.length();j++) {
		    		 String row2Char = "" + row2.charAt(j);
		    		 if(wordChar.equals(row2Char)) {
		    			 //if this word is equal to one of row2, set row2Matched flag to true
		    			 row2Matched=true;
		    		 }
		    	 }
		    	 //iterating row3 characters
		    	 for(int j=0;j<row3.length();j++) {
		    		 String row3Char = "" + row3.charAt(j);
		    		 if(wordChar.equals(row3Char)) {
		    			 //if this word is equal to one of row3, set row3Matched flag to true
		    			 row3Matched=true;
		    		 }
		    	 }
		     }
		     
		     //checking rowMatched flags
		     boolean wordIsValid = checkWordValidity(row1Matched,row2Matched,row3Matched);
		     if(wordIsValid) {
		    	 result[resultCounter] = word;
		    	 resultCounter++;
		     }
		}
		
		return result;
	}

	private boolean checkWordValidity(boolean row1Matched, boolean row2Matched, boolean row3Matched) {
		/*
		 * row1Matched true, row2Matched true, row3Matched true => word is not valid
		 * row1Matched true, row2Matched false, row3Matched true => word is not valid
		 * row1Matched true, row2Matched true, row3Matched false => word is not valid
		 * row1Matched false, row2Matched true, row3Matched true => word is not valid
		 * row1Matched true, row2Matched false, row3Matched false => word is valid
		 * row1Matched false, row2Matched true, row3Matched false => word is valid
		 * row1Matched false, row2Matched false, row3Matched true => word is valid
		 */
		if(row1Matched && row2Matched && row3Matched) {
			return false;
		}else if(row1Matched && !row2Matched && row3Matched) {
			return false;
		}else if(row1Matched && !row2Matched && row3Matched) {
		return false;
		}else if(row1Matched && row2Matched && !row3Matched) {
			return false;
		}else if(row1Matched && !row2Matched && !row3Matched) {
			return true;
		}else if(!row1Matched && row2Matched && !row3Matched) {
			return true;
		}else if(!row1Matched && !row2Matched && row3Matched) {
			return true;
		}

		return false;
	}
}
