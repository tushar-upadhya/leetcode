class Solution {
    public boolean isNice(int[] nums, int start, int end) {
        int mask = 0;
        for (int i = start; i <= end; i++) {
            if ((mask & nums[i]) != 0) 
                return false;
            mask |= nums[i];
        }
        return true;
    }

    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isNice(nums, i, j)) {
                    result = Math.max(result, j - i + 1);
                } else {
                    break; 
                }
            }
        }

        return result;
    }
}