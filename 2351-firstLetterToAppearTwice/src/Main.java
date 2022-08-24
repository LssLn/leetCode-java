
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s;
		
		s="abcacdef";
		System.out.println(sol.repeatedCharacter(s)); //c
		
		s="abccbaacz";
		System.out.println(sol.repeatedCharacter(s)); //c

		s="abcdd";
		System.out.println(sol.repeatedCharacter(s)); //d

	}

}
