class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;

        return mergeSort(nums, 0, n - 1);        
    }
    
    private int helper(int arr[], int low, int mid, int high){
        int right = mid + 1;
        int count = 0;

        for(int i = low; i <= mid; i++){
            while(right <= high && arr[i] > 2 * (long)arr[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    private int mergeSort(int arr[], int low, int high){
        int count = 0;
        
        if(low >= high) return count;
        
        int mid = low + (high - low) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += helper(arr, low, mid, high);

        merge(arr, low, mid, high);

        return count;
    }

    private void merge(int arr[], int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> tempList = new ArrayList<>();

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                tempList.add(arr[left]);
                left++;
            }else{
                tempList.add(arr[right]);
                right++;
            }
        } 
        while(left <= mid) tempList.add(arr[left++]);
        while(right <= high) tempList.add(arr[right++]);

        for(int i = low; i <= high; i++){
            arr[i] = tempList.get(i - low);
        }
    }
}