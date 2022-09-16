package src.classes;


public class Main {

	public static void main(String[] args) {
			Solution sol = new Solution();
			int maximumWordLengthBySpecs = 20;
			String[] words=new String[maximumWordLengthBySpecs];
			String[] result=new String[maximumWordLengthBySpecs];
			
			//https://stackoverflow.com/questions/10520617/why-can-array-constants-only-be-used-in-initializers
			words= new String[] {"Hello","Alaska","Dad","Peace"};
			result = sol.findWords(words);
			
			System.out.println("\n\nOutput:");
			for(String r : result) {
				System.out.println(r);
			}
			
			
			words= new String[] {"omk"};
			result = sol.findWords(words);
			
			System.out.println("\n\nOutput:");
			for(String r : result) {
				System.out.println(r);
			}
			
			
			words= new String[] {"adsdf","sfd"};
			result = sol.findWords(words);
			
			System.out.println("\n\nOutput:");
			for(String r : result) {
				System.out.println(r);
			}
			
			
	}

}
