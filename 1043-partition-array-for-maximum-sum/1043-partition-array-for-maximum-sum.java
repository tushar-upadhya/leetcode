class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, n, arr, k, dp);
    }
    
    private int helper(int index,int n, int arr[], int k, int dp[]){
        if(index == n) return 0;
        
        if(dp[index] != -1) return dp[index];
        
        int maxiSum =Integer.MIN_VALUE;
        int length = 0;
        int maxi = Integer.MIN_VALUE;
        
        for(int j = index; j < Math.min(index + k, n); j++){
            length++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (length * maxi) + helper(j + 1, n, arr, k, dp);
            maxiSum = Math.max(sum, maxiSum);
            
        }
        return dp[index] = maxiSum;
    }
}