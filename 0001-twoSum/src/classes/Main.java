package classes;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] array = {2,7,11,15};
		int target = 9;
		int[] index =  solution.twoSum(array, target);
		System.out.println("target: "+target+ "\nindex: " + index[0] + " " + index[1]);
	}

}
