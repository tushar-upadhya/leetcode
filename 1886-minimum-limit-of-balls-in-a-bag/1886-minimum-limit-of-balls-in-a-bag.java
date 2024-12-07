class Solution {
    public boolean isPossible(int[] nums, int maxOps, int mid) {
        int totalOps = 0; // To bring each number <= mid

        for (int num : nums) {
            int ops = num / mid;

            if (num % mid == 0) {
                ops -= 1;
            }

            totalOps += ops;
        }

        return totalOps <= maxOps;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt(); // Find max in nums
        
        int result = right; // We have to minimize this

        // Binary search: O(n * log(MAX))
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, maxOperations, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}