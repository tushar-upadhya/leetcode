class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int result[][] = new int[nums.length / 3][3];
        int index = 0;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i += 3){
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            
            if(third - first <= k){
                result[index][0] = first;
                result[index][1] = second;
                result[index][2] = third;
                index++;
            }else{
                return new int[0][0];
            }
        }
        return result;
    }
}