import java.util.*;

public class Main {
  public static void main(String[] args) {
  		Scanner input = new Scanner(System.in);
	    try {
	      	String input1 = input.next();
	      	String solution = sortVowels(input1);
	      	System.out.println("return: "+solution);
	    } finally {
	    	input.close();
	    }
  }
  
  public static String sortVowels(String input) {
//	  input=input.toLowerCase();
	  StringBuilder output = new StringBuilder();;
	  ArrayList<String> vowels = new ArrayList<>();
	  if(input!=null) {
		  for(int i=0;i<input.length();i++) {
			  String c = ""+input.charAt(i);
			  if(isAVowel(c)) {
				  vowels.add(c);
			  }
		  }
		  if(!vowels.isEmpty()) {
			  System.out.print("vowels: "+vowels.toString());
			  Collections.reverse(vowels);
			  System.out.println(" --> "+vowels.toString());
			  
			  for(int j=0;j<input.length();j++) {
				  String c = ""+input.charAt(j);
				  if(isAVowel(c)) {
					  output.append(vowels.get(0));
					  vowels.remove(0);
				  }else {
					  output.append(input.charAt(j));
				  }
				  
			  }
		  }
	  }	  
	  return output.toString();
  }
  
  public static boolean isAVowel(String s) {
	  if("aeiou".contains(s) || "AEIOU".contains(s)) {
		  return true;
	  }else {
		  return false;
	  }
  }
}