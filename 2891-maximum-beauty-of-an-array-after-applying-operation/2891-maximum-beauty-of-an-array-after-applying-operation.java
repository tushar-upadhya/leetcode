class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int i = 0;
        int j = 0;
        int maxi = 0;

        while (i < n) {
            while (j < n && nums[j] - nums[i] <= 2 * k) {
                j++;
            }
            maxi = Math.max(maxi, j - i);
            i++;
        }
        return maxi;
    }
}