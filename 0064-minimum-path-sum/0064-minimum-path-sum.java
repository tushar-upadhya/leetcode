class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return helper(grid.length - 1, grid[0].length - 1, grid, dp);
    }

    private static int helper(int i, int j, int arr[][], int dp[][]){
        if(i == 0 && j == 0){
            dp[i][j] = arr[0][0];

            return dp[i][j];
        }

        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int upWard = Integer.MAX_VALUE;
        int leftWard = Integer.MAX_VALUE;

        if(i > 0){
            upWard = arr[i][j] + helper(i - 1, j, arr, dp);
        }

        if(j > 0){
            leftWard = arr[i][j] + helper(i, j - 1, arr, dp);
        }

        dp[i][j] = Math.min(leftWard, upWard);

        return dp[i][j];
    }
}