class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(nums[mid] >= nums[start]){
                min = Math.min(nums[start], min);
                start = mid + 1;
            }else{
                min = Math.min(nums[mid], min);
                end = mid - 1;
            }
        }
        return min;
    }
}