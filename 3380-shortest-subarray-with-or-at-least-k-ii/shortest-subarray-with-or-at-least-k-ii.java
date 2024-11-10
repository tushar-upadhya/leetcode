class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int count[] = new int[32];
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while(end < nums.length){
            updateBits(count, nums[end], 1);

            while(start <= end && getValue(count) >= k){
                min = Math.min(min, end - start + 1);
                updateBits(count, nums[start], -1);
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void updateBits(int count[], int num, int val){
        for(int i = 0; i < 32; i++){
            if(((num >> i) & 1) == 1)
            count[i] += val;
        }
    }

    private int getValue(int count[]){
        int result = 0;
        for(int i = 0; i < 32; i++){
            if(count[i] > 0)
            result = result | (1 << i);
        } 
        return result;
    }
}