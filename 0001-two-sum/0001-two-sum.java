class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        int result[] = new int[2];
        
        for(int i = 0; i < arr; i++){
            if(map.containsKey(target - nums[i])){
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}