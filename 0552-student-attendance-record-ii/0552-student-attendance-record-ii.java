class Solution {
    public int checkRecord(int n) {
        if (n == 1) return 3; 
		
        int mod = 1000000007;
        long dp[][] = new long[n + 1][6];
		
        dp[2][0] = 2;   
        dp[2][1] = 1;   
        dp[2][2] = 1;   
        dp[2][3] = 3;   
        dp[2][4] = 1;   
        dp[2][5] = 0;   
        
        for (int i = 3; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;       
            dp[i][1] = dp[i - 1][0] % mod;                                       
            dp[i][2] = dp[i - 1][1] % mod;                                       
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5]) % mod;               
            dp[i][4] = dp[i - 1][3] % mod;                                       
            dp[i][5] = dp[i - 1][4] % mod;                                       
        }
        
        return (int)((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] + dp[n][5]) % mod);
    }
}