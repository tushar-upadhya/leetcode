class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        
        helper(0, nums, result, new ArrayList<>(), k);
        
        return result.size();
    }
    
    private void helper(int index, int[] nums, List<List<Integer>> result, List<Integer> list, int k){
        
        if(index == nums.length){
            if(list.size() > 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(!(list.contains(nums[index] - k) )){
            list.add(nums[index]);
            
            helper(index + 1, nums, result, list, k);

            list.remove(list.size() - 1);
        }
        helper(index + 1, nums, result, list, k);
    }
}