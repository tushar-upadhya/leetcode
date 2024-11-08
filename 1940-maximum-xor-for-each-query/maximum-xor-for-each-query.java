class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int result[] = new int[n];
        int maxi = (1 << maximumBit) - 1;
        int totalXor = 0;

        for(int num : nums){
            totalXor ^= num;
        }

        for(int i = 0; i < n; i++){
            result[i] = totalXor ^ maxi;
            totalXor ^= nums[n - 1 - i];
        }
        return result;
    }
}