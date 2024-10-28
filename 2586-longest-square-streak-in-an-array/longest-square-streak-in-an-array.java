class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;

        for(int num : nums){
            int perfect = (int)Math.sqrt(num);

            if(perfect * perfect == num && map.containsKey(perfect)){
                map.put(num, map.get(perfect) + 1);

                result = Math.max((map.get(perfect) + 1), result);
            }else{
                map.put(num, 1);
            }
        }
        return result;
    }
}