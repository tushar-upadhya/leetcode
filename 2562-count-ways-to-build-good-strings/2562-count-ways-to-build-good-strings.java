class Solution {
    private int MOD = (int) 1e9 + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        if(zero > one){
            return countGoodStrings(low, high, one, zero);
        }
        int dp[] = new int[high + 1];
        int result = 0;

        dp[0] = 1;

        for(int i = 1; i <= high; i++){
            if(i >= zero)
            dp[i] = (dp[i] + dp[i - zero]) % MOD;

            if(i >= one)
            dp[i] = (dp[i] + dp[i - one]) % MOD;

            if(i >= low)
            result = (result + dp[i]) % MOD;
        }
        return result;
        
    }
}