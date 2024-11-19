class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        long result = 0;
        long currentWindowSum = 0;
        Set<Integer> set = new HashSet<>();

        while(j < nums.length){
            while(set.contains(nums[j])){
                currentWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            currentWindowSum += nums[j];
            set.add(nums[j]);

            if(j - i + 1 == k){
                result = Math.max(result, currentWindowSum);

                currentWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return result;
    }
}