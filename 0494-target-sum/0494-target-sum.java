class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }

        if(sum < target){
            return 0;
        }

        if((sum - target) % 2 == 1) return 0;

        int tar = (sum - target) / 2;

        return helper(nums, nums.length - 1, tar);
    }

    private int helper(int nums[], int n, int target){
        if(n == 0){
            if(target == 0 && nums[0] == 0) return 2;

            if(target == 0 || target == nums[0]) return 1;

            return 0;
        }
        if(target < 0 || n < 0) return 0;
        
        int take = 0;

        if(nums[n] <= target){
            take = helper(nums, n - 1, target - nums[n]);
        }

        int notTake = helper(nums, n - 1, target);

        return take + notTake;
    }
}