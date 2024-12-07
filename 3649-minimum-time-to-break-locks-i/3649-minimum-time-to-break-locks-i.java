class Solution {
    long[][] memo;
    List<Integer> list;
    int n;
    int k;
    List<Integer> strength;

    private long dp(int mask, int X){
        if(mask == (1 << n) - 1) return 0;
        if(memo[mask][X] != -1) return memo[mask][X];

        long result = Long.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            if((mask & (1 << i)) == 0){
                long t = (long) Math.ceil((double) strength.get(i) / X);
                int nextX = X + k;
                long totalTime = t + dp(mask | (1 << i), nextX);
                result = Math.min(result, totalTime);
            }
        }
        return memo[mask][X] = result;
    }
    public int findMinimumTime(List<Integer> strengthInput, int KInput) {
        strength = strengthInput;
        k = KInput;
        n = strength.size();
        list = new ArrayList<>(strength);

        memo = new long[1 << n][100];
        for(int i = 0; i < (1 << n); ++i){
            for(int j = 0; j < 100; ++j){
                memo[i][j] = -1;
            }
        }
        long ans = dp(0, 1);
        return (ans <= 1e12) ? (int) ans : -1;
    }
}