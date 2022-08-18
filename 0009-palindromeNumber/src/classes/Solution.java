package classes;

public class Solution {
	public int reverseNumber(int x) {
		int reverse = 0;  
	      while(x != 0){  
	          int remainder = x % 10;  
	          reverse = reverse * 10 + remainder;  
	          x = x/10;  
	      }  
	      System.out.println("The reverse of the given number is: " + reverse);  
	      return reverse;
	}
	public boolean isPalindrome(int x) {
		if(x<0) {
			return false;
		}
		int reverse = reverseNumber(x);
		if(reverse == x) {
			return true;
		}else {
			return false;
		}
	}
}
