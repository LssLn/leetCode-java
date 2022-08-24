import java.util.ArrayList;
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
			}
		}
		
		
		return result;
    }
}
