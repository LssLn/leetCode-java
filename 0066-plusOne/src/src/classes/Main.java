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
		
		digits = new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
		result = sol.plusOne(digits);
		System.out.print("Result: [ ");
		for(int r : result) {
			System.out.print(r+" ");
		}
		System.out.println("]\n");
		
	}

}
