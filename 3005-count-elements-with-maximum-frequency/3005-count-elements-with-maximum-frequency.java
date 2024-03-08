class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        int count = 0;
        
        for(int maps : map.values()){
            if(maps == maxFreq) count++;
            else if(maps > maxFreq){
                maxFreq = maps;
                count = 1;
            }
        }
        return maxFreq * count;
    }
}