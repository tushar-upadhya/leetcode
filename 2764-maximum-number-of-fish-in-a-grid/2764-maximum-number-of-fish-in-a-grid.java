class Solution {
    public int findMaxFish(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0 ;j < grid[0].length; j++){
                if(grid[i][j] > 0)
                max=Math.max(max, helper(grid, i , j));
            }
        }
        return max;
    }
    int helper(int[][] grid,int x,int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return 0;
        int t = grid[x][y];
        grid[x][y] = 0;
        int l = helper(grid, x - 1, y);
        int r = helper(grid, x + 1, y);
        int u = helper(grid, x, y - 1);
        int d = helper(grid, x, y + 1);
        int max = t + l + u + r + d;

        return max;
    }
}