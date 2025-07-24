class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        
        int c = cuts.length;

        List<Integer> list = new ArrayList<>();
        list.add(0);

        for(int i = 0; i < c; i++){
            list.add(cuts[i]);
        }
        list.add(n);

        int dp[][] = new int[c + 1][c + 1];

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return helper(1, c, list, dp);
    }

    private int helper(int i, int j, List<Integer> list, int dp[][]){
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for(int index = i; index <= j; index++){
            int cost = list.get(j + 1) - list.get(i - 1) + helper(i, index - 1, list, dp) + helper(index + 1, j, list, dp);

            mini = Math.min(mini, cost);
        }
        dp[i][j] = mini;

        return dp[i][j];
    }
}