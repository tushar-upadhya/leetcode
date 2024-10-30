class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int result1[] = new int[n];
        int result2[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < n; i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
                result1[i] = list.size();
            }else{
                int index = helper(list, nums[i]);
                list.set(index, nums[i]);
                result1[i] = index + 1;
            }
        }
        list.clear();
        list.add(nums[n - 1]);
      
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
                result2[i] = list.size();
            }else{
                int index = helper(list,nums[i]);
                list.set(index, nums[i]);
                result2[i] = index + 1;
            }
        }

        int result = 0;
        for(int i = 1; i < n - 1; i++){
            if(result1[i] > 1 && result2[i] > 1){
                result= Math.max(result, result1[i] + result2[i] - 1);
            }
        }
        return nums.length - result;
    }

    private int helper(ArrayList<Integer> list,int target){
        int i = 0;
        int j = list.size() - 1;
        while(i <= j){
            int mid = (i + j) / 2;

            if(list.get(mid) <= target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return list.get(Math.max(j, 0)) == target ? j : i;
    }
}