class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0;
        int result = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            sum = (sum + nums[i]) % k;

            if(sum < 0) sum += k;

            result += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}