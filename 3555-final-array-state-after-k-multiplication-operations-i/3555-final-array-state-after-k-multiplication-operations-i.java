class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for(int j = 0; j < k; j++){
            int index = 0;

            for(int i = 0; i < n; i++){
                if(nums[i] < nums[index]){
                    index = i;
                }
            }
            nums[index]  *= multiplier;
        }
        return nums;
    }
}