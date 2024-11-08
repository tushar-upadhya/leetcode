   class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
         boolean visited[] = new boolean[nums.length];
         helper(result ,nums, new ArrayList(), visited);
         return result;
    }

    private void helper(List<List<Integer>> result, int nums[],List<Integer> current, boolean[] visited){
                if(current.size() == nums.length){
                 result.add(new ArrayList(current));
                    return;
                }

                for(int i = 0; i < nums.length; i++){
                    if(visited[i] == true)continue;
                    current.add(nums[i]);
                    visited[i] = true;
                    helper(result, nums, current, visited);
                    current.remove(current.size() - 1);
                    visited[i] = false;
                } 
    }
}