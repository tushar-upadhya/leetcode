class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        result.add(new ArrayList<>());
        
        for(int i = 0; i < nums.length; i++){
            int n = result.size();
            
            for(int j = 0; j < n; j++){
                result.add(new ArrayList<>(result.get(j)));
                result.get(result.size() - 1).add(nums[i]);
            }
        }
        return result;
    }
}