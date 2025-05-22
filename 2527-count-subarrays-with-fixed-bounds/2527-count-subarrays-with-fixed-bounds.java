class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1;
        int max = -1;
        int bad = -1;
        long result = 0;

        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == minK) min = i;
            if(nums[i] == maxK) max = i;
            if(nums[i] < minK || nums[i] > maxK) bad = i;

            if(min != -1 && max != -1){
                result += Math.max(0, Math.min(min, max) - bad);
            }
        }
        return result;
    }
}