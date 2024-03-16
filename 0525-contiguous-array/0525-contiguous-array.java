class Solution {
    public int findMaxLength(int[] nums) {
        int maxSum = 0;
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
		
        map.put(0, -1);
		
        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i] == 0 ? -1 : nums[i];
			
            if(map.containsKey(currentSum)){
                maxSum = Math.max(maxSum, i - map.get(currentSum));
            } else {
                map.put(currentSum, i);
            }
			
        }
		
        return maxSum;
    }
}