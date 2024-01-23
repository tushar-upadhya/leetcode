class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            if(!duplicate.add(nums[i])) continue;
            
            for(int j = i + 1; j < nums.length; j++){
                int value = 0 - nums[i] - nums[j];
                if(map.containsKey(value) && map.get(value) == i){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], value));
                    
                    Collections.sort(list);
                    result.add(list);
                }
                map.put(nums[j], i);
            }
        }
        return new ArrayList<>(result);
    }
}