class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];

        helper(used, result, new ArrayList<>(), nums);

        return result;
    }

    private void helper(boolean used[], List<List<Integer>> result, List<Integer> temp, int nums[]){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            temp.add(nums[i]);
            used[i] = true;

            helper(used, result, temp, nums);
            temp.remove(temp.size() - 1);

            used[i] = false;
        }
    }
}