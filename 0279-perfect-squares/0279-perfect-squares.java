class Solution {
    public int numSquares(int n) {
        int memo[] = new int[n + 1];
        return helper(n, memo);
    }
    
    int helper(int n, int memo[]){
        if(n < 4) return n;
        
        if(memo[n] != 0) return memo[n];
        
        int result = n;
        
        for(int i = 1; i * i <= n; i++){
            int sqaure = i * i;
            
            result = Math.min(result, 1 + helper(n - sqaure, memo));
        }
        return memo[n] = result;
    }
}