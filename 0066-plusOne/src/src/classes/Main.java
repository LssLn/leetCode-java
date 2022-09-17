package src.classes;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] digits = {1,2,3};
		int[] result;
		
		result = sol.plusOne(digits);
		System.out.print("Result: [ ");
		for(int r : result) {
			System.out.print(r+" ");
		}
		System.out.println("]\n");
		
		digits = new int[]{4,3,2,1};
		result = sol.plusOne(digits);
		System.out.print("Result: [ ");
		for(int r : result) {
			System.out.print(r+" ");
		}
		System.out.println("]\n");
		
		digits = new int[]{9};
		result = sol.plusOne(digits);
		System.out.print("Result: [ ");
		for(int r : result) {
			System.out.print(r+" ");
		}
		System.out.println("]\n");
		
		digits = new int[]{9,8,7,6,5,4,3,2,1,0};
		result = sol.plusOne(digits);
		System.out.print("Result: [ ");
		for(int r : result) {
			System.out.print(r+" ");
		}
		System.out.println("]\n");
		
	}

}
