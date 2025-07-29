class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int k = 2;

        for(int j = 0; j < nums.length; j++){
            if(i < k || nums[j] > nums[i - k]){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}