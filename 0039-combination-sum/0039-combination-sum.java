class Solution {
    public void helper(int[] arr, int target, int index, List<List<Integer>> result,List<Integer> list){
        if(index == arr.length){
            
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[index] <= target){
            list.add(arr[index]);
            
            helper(arr, target - arr[index], index, result, list);
            
            list.remove(list.size() - 1);
        }
        helper(arr, target, index+1, result, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(candidates, target,0, result, list);
        return result;
    }
}