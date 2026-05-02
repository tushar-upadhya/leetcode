class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;

        for(int n : nums){
            result = Math.max(result, n);
        }
        int currentMax = 1;
        int currentMin = 1;

        for(int n : nums){
            int temp = currentMax * n;
            currentMax = Math.max(temp, Math.max(currentMin * n, n));
            currentMin = Math.min(temp, Math.min(currentMin * n, n));

            result = Math.max(result, currentMax);
        }
        return result;
    }
}