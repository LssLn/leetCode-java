package classes;

public class Solution {
	public boolean containsVowels(String c) {
		if(c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean halvesAreAlike(String s) {
        boolean result=false;
        int sLength = s.length();
        //input string has even length
        String s1 = s.substring(0,sLength/2);
        int nVowelsS1 = 0;
        String s2 = s.substring(sLength/2,sLength);
        int nVowelsS2 = 0;

        
        System.out.println(s+" -> "+s1+" | "+s2);
        
        //getting s1 vowels
        for(int j=0; j<s1.length(); j++) {
        	String c = "" + s1.charAt(j);
        	c=c.toLowerCase();
        	if(containsVowels(c)) {
        		nVowelsS1++;
        	}
        }
        
      //getting s2 vowels
        for(int j=0; j<s2.length(); j++) {
        	String c = "" + s2.charAt(j);
        	c=c.toLowerCase();
        	if(containsVowels(c)) {
        		nVowelsS2++;
        	}
        }
        
        System.out.println(s1+" vowels: "+nVowelsS1+", "+s2+" vowels: "+nVowelsS2);
        
        if(nVowelsS1 == nVowelsS2) {
        	result=true;
        }else {
        	result=false;
        }

        
		return result;
    }
}
