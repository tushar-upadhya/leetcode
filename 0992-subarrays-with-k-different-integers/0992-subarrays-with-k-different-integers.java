class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int maxK = helper(nums, k);
        int reduceMaxK = helper(nums, k - 1);
        
        return maxK - reduceMaxK;
    }
    
    private int helper(int nums[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while(map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}