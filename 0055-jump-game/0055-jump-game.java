class Solution {
    public boolean canJump(int[] nums) {
        int n = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i > n) return false;
            
            n = Math.max(n, i + nums[i]);
        }
        return true;
    }
}