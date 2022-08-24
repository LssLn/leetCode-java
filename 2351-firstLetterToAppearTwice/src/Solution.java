import java.util.HashMap;
import java.util.Map;

public class Solution {
	public char repeatedCharacter(String s) {
        char result = 0;
		Map<String, Integer> countMap = new HashMap<>(); //containing char, count
        
		//counting the characters count values
		for(int i=0;i<s.length();i++) {
			String c = ""+s.charAt(i);
			if(countMap.get(c)!=null) {
				//the map contains a value for the key c, the c value is already present (c at least twice)
				countMap.put(c,countMap.get(c)+1); //updating existing value associated with key c: count++
				
			}else {
				//new key
				countMap.put(c, 1); //count initialized at 1
			}
		}
		
		Map<String, Integer[]> indexMap = new HashMap<>(); //containing char, and indexes
		//filtering the characters with count values >1, storing the position indexes in the String
		for(String c:countMap.keySet()) {
			if(countMap.get(c) > 1) {
				int arrayIndex=0;
				Integer[] indexes = new Integer[s.length()]; //maximum number of count == maximum input length
				for(int i=0;i<s.length();i++) {
					String tmp = ""+s.charAt(i);
					if(tmp.equals(c)) {
						indexes[arrayIndex]=i;
						arrayIndex++;
					}
				}
				indexMap.put(c, indexes);
			}
		}
		
		//indexMap contains the indexes of the chars that are repeated
		
		//calculating the first repeating
		
		int smallerIndex = 101; //will always be > than any index
		//element with indexes[1] smaller is the first repeating
		for(String c:indexMap.keySet()) {
			Integer[] cIndex = indexMap.get(c); 
			if(cIndex[1]<smallerIndex) {
				result= c.charAt(0);
			}
		}
		return result;
    }
}
