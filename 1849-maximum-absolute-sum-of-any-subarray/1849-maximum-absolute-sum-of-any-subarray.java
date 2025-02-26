class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currentSubSum = nums[0];
        int maxSubSum = nums[0];

        for(int i = 1; i < n; i++){
            currentSubSum = Math.max(nums[i], currentSubSum + nums[i]);
            maxSubSum = Math.max(maxSubSum, currentSubSum);
        }
        int minSubSum = nums[0];
        currentSubSum = nums[0];

        for(int i = 1; i < n; i++){
            currentSubSum = Math.min(nums[i], currentSubSum + nums[i]);
            minSubSum = Math.min(minSubSum, currentSubSum);
        }
        return Math.max(maxSubSum, Math.abs(minSubSum));
    }
}