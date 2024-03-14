class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int result = 0;
        
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){
            currentSum = currentSum + nums[i];
            result += map.getOrDefault(currentSum - goal, 0);
            
            if(map.containsKey(currentSum))
                map.put(currentSum, map.get(currentSum) + 1);
            else
                map.put(currentSum, 1);
        }
        return result;
    }
}