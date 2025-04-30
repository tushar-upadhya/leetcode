class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mv = 0;
        
        for(int val : nums) mv = Math.max(mv, val);
        
        long result = 0;
        int count = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == mv) count++;

            while(count >= k){
                if(nums[left] == mv) count--;
                left++;
            }
            result += left;
        }
        return result;
    }
}