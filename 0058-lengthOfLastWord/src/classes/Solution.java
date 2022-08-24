package classes;

public class Solution {
	public int lengthOfLastWord(String s) {        
        String[] splited = s.trim().split("\\s+");
        return splited[splited.length-1].length();
    }
}
