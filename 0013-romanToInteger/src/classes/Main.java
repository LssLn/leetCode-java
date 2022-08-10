package classes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "III";
		int r =  solution.romanToInt(s);
		System.out.println(s+": "+r);
		
		s = "LVIII";
		r =  solution.romanToInt(s);
		System.out.println(s+": "+r);
		
		s = "MCMXCIV";
		r =  solution.romanToInt(s);
		System.out.println(s+": "+r);
	}

}
