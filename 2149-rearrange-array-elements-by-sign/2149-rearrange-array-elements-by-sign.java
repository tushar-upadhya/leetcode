class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int postive = 0;
        int negative = 1;
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                result[postive] = nums[i];
                postive += 2;
            }else{
                result[negative] = nums[i];
                negative += 2;
            }
        }
        return result;
    }
}