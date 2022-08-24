package classes;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s;
		boolean res;
		
		s="flower";
		res=sol.halvesAreAlike(s);
		System.out.println(res);
		
		s="book";
		res=sol.halvesAreAlike(s);
		System.out.println(res);
		
		s="textbook";
		res=sol.halvesAreAlike(s);
		System.out.println(res);
		
		s="ssssaass";
		res=sol.halvesAreAlike(s);
		System.out.println(res);
	}

}
