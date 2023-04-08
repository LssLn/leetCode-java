import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String digits = "23";
		List<String> res = sol.letterCombinations(digits);
		System.out.println(res.size()+res.toString());
	
		digits = "239";
		res = sol.letterCombinations(digits);
		System.out.println(res.size()+res.toString());
		
	}

}
