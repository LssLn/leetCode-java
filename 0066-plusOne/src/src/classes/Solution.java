package src.classes;

public class Solution {
	public int[] plusOne(int[] digits) {
		int[] result = new int[101]; //constraint + 1 for worst case
		
		//Converting int[] to int
		StringBuilder sb = new StringBuilder();
		for(int d : digits) {
			System.out.print(d+" ");
			sb.append(d);
		}
		int number = Integer.parseInt(sb.toString());
		System.out.println("intDigits: "+number);
		return result;
    }
}
