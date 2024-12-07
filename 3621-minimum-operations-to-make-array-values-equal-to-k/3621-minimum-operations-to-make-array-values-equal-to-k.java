class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int count = 0;

        for(int num : set){
            if(num > k){
                count++;
            }else if(num < k){
                return -1;
            }
        }
        return count;
    }
}