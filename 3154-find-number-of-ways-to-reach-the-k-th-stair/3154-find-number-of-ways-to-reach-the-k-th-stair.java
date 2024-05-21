class Solution {
    public int waysToReachStair(int k) {
        int num = 1;
        int result = 0;
        
        if(k == 0 || k == 1) result++;
        
        int dp[][] = new int[50][50];
        dp[0][0] = 1;
        
        for(int i = 1; i < 50; ++i){
            dp[i][0] = 1;
            
            for(int j = 1; j <= i; ++j){
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        for(int i = 0; i < 30; ++i){
            num += 1 << i;
            
            if(num >= k && num - k <= i + 2){
                int current = i + 2;
                int newCurrent = num - k;
                
                result += dp[current][newCurrent];
            }
        }
        return result;
    }
}