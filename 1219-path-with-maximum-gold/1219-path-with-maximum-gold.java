class Solution {
    int[] row = {1, -1, 0, 0};
    int[] col = {0, 0, -1, 1};
    int maxGold = 0;

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, helper(grid, i, j, n, m));
                }
            }
        }

        return maxGold;
    }

    private int helper(int[][] grid, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) return 0;
        
        int current = grid[x][y];
        grid[x][y] = 0;
        int localMaxGold = current;

        for (int i = 0; i < 4; i++) {
            int newX = x + row[i];
            int newY = y + col[i];
            localMaxGold = Math.max(localMaxGold, current + helper(grid, newX, newY, n, m));
        }

        grid[x][y] = current;
        return localMaxGold;
    }
}
