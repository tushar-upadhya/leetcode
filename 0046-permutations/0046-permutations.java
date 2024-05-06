class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(0, nums, list);
        
        return list;
    }
    
    private void helper(int index, int nums[], List<List<Integer>> list){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < nums.length; i++) temp.add(nums[i]);
            list.add(temp);
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, index, i);
            helper(index + 1, nums, list);
            swap(nums, index, i);
        }
    }
    
    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}