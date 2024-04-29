class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        
        for(int i = 0; i <= 30; i++){
            int m = 0;
            
            for(int j = 0; j < n; j++){
                if(((nums[j] >> i) & 1) == 1) m = m ^ 1;
            }
            if(((k >> i) & 1) != m) result ++;
        }
        return result;
    }
}