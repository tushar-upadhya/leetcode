class Solution {
    public boolean canSortArray(int[] nums) {
        int l = nums.length;
        int currentMin = nums[0];
        int currentMax = nums[0];
        int prevMax = Integer.MIN_VALUE;

        for(int i : nums){
            if(Integer.bitCount(i) == Integer.bitCount(currentMin)){
                currentMin = Math.min(currentMin, i);
                currentMax = Math.max(currentMax, i);
            }else{
                if(currentMin < prevMax) return false;
                prevMax = currentMax;
                currentMin = i;
                currentMax = i;
            }
        }
        return currentMin > prevMax;
    }
}