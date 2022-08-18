package classes;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int number=121;
		boolean isPalindrome = solution.isPalindrome(number);
		System.out.println("is "+number+" palindrome?: " +isPalindrome);
		
		number=1215;
		isPalindrome = solution.isPalindrome(number);
		System.out.println("is "+number+" palindrome?: " +isPalindrome);
		
		number=15951;
		isPalindrome = solution.isPalindrome(number);
		System.out.println("is "+number+" palindrome?: " +isPalindrome);
		
		number=-15951;
		isPalindrome = solution.isPalindrome(number);
		System.out.println("is "+number+" palindrome?: " +isPalindrome);
	}
}
