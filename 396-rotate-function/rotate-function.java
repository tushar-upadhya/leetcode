class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count += i * nums[i];
        }

        int max = count;

        for (int i = 1; i < n; i++) {
            count += sum - n * nums[n - i];
            max = Math.max(max, count);
        }

        return max;
    }
}