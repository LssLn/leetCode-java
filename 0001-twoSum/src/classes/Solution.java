package classes;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] resultIndex= {0,0};
    	int length = nums.length;
    	int current=0;
    	int next=0;
    	
        for(int i=0;i<length;i++){
        	current=nums[i];
        	// confronting current element with all the others (next), whose must be different (unique elements) from current
        	for(int j=0;j<length;j++) {
        		if(i != j) { // cannot confront the element with itself
        			if(nums[i]+nums[j]==target) {
        				resultIndex[0]=i;
        				resultIndex[1]=j;
        			}
        		}
        	}
        }
        return resultIndex;
    }
}