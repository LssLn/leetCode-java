package classes;

public class Solution {
	public String[] findWords(String[] words) {
		//init words fitting, maximum size is equal to words
		String[] result= new String[words.length];
		String row1 = "qwertyuiop";
		String row2 = "asdfghjkl";
		String row3 = "zxcvbnm";
		//iterating words array
		for(String word:words) {
			System.out.println("\nWord: "+word+" :");
			//iterating each word characters
		     for(int i=0;i<word.length();i++) {
		    	 String wordChar = "" + word.charAt(i);
		    	 System.out.print(" "+wordChar);
		    	 //iterating row1 characters
		    	 for(int j=0;j<row1.length();j++) {
		    		 
		    	 }
		     }
		}
		
		return result;
	}
}
