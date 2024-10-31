class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // startind index is 0;
        helper(target , 0 , candidates , result , new ArrayList<>());
        return result;
    }
    private void helper(int target, int index, int arr[], List<List<Integer>> result , List<Integer>list){
        //if our index reaches tot the end of arr then we check the target becomes zero or not;
        if(index == arr.length){
            if(target == 0){
                //target becomes zero so we add list list in our result list;
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[index] <= target){
            list.add(arr[index]);
            helper(target - arr[index], index, arr, result, list);
            list.remove(list.size() - 1);
        }
        helper(target, index + 1, arr, result, list);
    }
}