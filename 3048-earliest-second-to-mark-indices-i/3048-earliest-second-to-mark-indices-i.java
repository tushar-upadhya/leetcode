class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int left = 0;
        int right = changeIndices.length - 1;
        int mid;
        int result = -1;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            
            if(helper(nums, changeIndices, mid)){
                result = mid + 1;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }
    
    private boolean helper(int nums[], int index[], int k){
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        boolean visited[] = new boolean[k + 1];
        
        for(int i = k; i >= 0; i--){
            if(set.contains(index[i])) continue;
            
            visited[i] = true;
            set.add(index[i]);
        }
        if(set.size() != n) return false;
        
        int needed = 0;
        int available = 0;
        
        for(int i = 0; i <= k; i++){
            if(!visited[i]){
                available++;
            }else{
                needed += nums[index[i] - 1];
                
                if(needed > available) return false;
            }
        }
        return true;
    }
}