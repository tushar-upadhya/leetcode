class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> list= new ArrayList<>();

        Arrays.sort(nums);
        helper(nums, visited, result, list);
        
        return result;
    }
    
    private void helper(int[] nums,boolean[] visited, List<List<Integer>> result, List<Integer> list){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){            
            if(!visited[i]){
                list.add(nums[i]);

                visited[i] = true;
                helper(nums, visited, result, list);

                visited[i] = false;
                list.remove(list.size() - 1);

                while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;                
            }
        }
    }
}