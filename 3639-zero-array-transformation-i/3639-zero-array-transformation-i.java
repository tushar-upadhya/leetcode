class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int arr[] = new int[nums.length + 1];

        for(int query[] : queries){
            int left = query[0];
            int right = query[1];
            arr[left] += 1;
            arr[right + 1] -= 1;
        }

        int count[] = new int[arr.length];
        int current = 0;

        for(int i = 0; i < arr.length; i++){
            current += arr[i];
            count[i] = current;
        }

        for(int i = 0; i < nums.length; i++){
            if(count[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}