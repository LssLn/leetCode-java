package src.classes;

public class Solution {
	public int[] plusOne(int[] digits) {		
		//Converting int[] to string
		StringBuilder sb = new StringBuilder();
		System.out.print("Array in input: [ ");
		for(int d : digits) {
			System.out.print(d+" ");
			sb.append(d);
		}
		System.out.println("]");
		
		//converting string to int
		int number = Integer.parseInt(sb.toString());
		System.out.println("intDigits: "+number);
		
		//adding plus one
		number++;
		String strNumber = String.valueOf(number);
		
		
		//converting int to int[]
		//getting the length of the int value
		int length = String.valueOf(number).length();
		System.out.println("length of the converted value +1 "+number+" : "+length);
		
		int[] result = new int[length];
		
		for(int i=0;i<length;i++) {
			result[i]=strNumber.charAt(i)-48; //ASCII conversion
		}
		

		return result;
    }
}
