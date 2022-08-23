package classes;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		String[] s = {"flower","flow","flight"};
		System.out.println(solution.longestCommonPrefix(s));
		
		String[] s2 = {"flower","flow"};
		System.out.println(solution.longestCommonPrefix(s2));
		
		String[] s3 = {"sun","suneater"};
		System.out.println(solution.longestCommonPrefix(s3));
		
		String[] s4 = {"smeargle","cat","smear"};
		System.out.println(solution.longestCommonPrefix(s4));
	}
}
