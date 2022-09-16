package classes;

public class Main {

	public static void main(String[] args) {
			Solution sol = new Solution();
			String[] words=new String[20];
			
			//https://stackoverflow.com/questions/10520617/why-can-array-constants-only-be-used-in-initializers
			words= new String[] {"Hello","Alaska","Dad","Peace"};
			sol.findWords(words);
	}

}
