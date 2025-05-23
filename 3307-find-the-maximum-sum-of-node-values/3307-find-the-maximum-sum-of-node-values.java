class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        long count = 0;
        int mini = Integer.MAX_VALUE;

        for(int num : nums){
            if((num ^ k) > num){
                count++;
                sum += (num ^ k);
            }else{
                sum += num;
            }
            mini = Math.min(mini, Math.abs(num - (num ^ k)));
        }

        if(count % 2 == 0) return sum;

        return sum - mini;
    }
}