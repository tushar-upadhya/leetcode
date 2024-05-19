class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        
        int[] options1 = new int[n];
        int[] options2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            options1[i] = nums[i];
            options2[i] = nums[i] ^ k;
        }
        
        long odd = options2[0];
        long even = options1[0];
        
        for (int i = 1; i < n; i++) {
            long newOdd = Math.max(odd + options1[i], even + options2[i]);
            long newEven = Math.max(even + options1[i], odd + options2[i]);
            
            odd = newOdd;
            even = newEven;
        }
        
        return even;
    }
}