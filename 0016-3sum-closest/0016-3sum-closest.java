class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        int closestSum = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }
                if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return closestSum;
    }
}