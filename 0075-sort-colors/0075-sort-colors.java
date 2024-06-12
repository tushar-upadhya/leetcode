class Solution {
    public void sortColors(int[] nums) {
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        int index = 0;

        while(index <= pointer2){
            if(nums[index] == 0){
                nums[index] = nums[pointer1];
                nums[pointer1] = 0;
                pointer1++;
            }

            if(nums[index] == 2){
                nums[index] = nums[pointer2];
                nums[pointer2] = 2;
                pointer2--;
                index--;
            }

            index++;
        }
    }
}