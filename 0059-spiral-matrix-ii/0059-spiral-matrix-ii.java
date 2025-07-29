class Solution {
     public int[][] generateMatrix(int n) {
        int result[][] = new int[n][n];
        int m = 1;
        int d = 0;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;

        while (m <= n * n) {
            result[row][col] = m++;
            
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);
            
            if (result[r][c] != 0) d = (d + 1) % 4;
            
            row += dir[d][0];
            col += dir[d][1];
            
        }
        return result;
    }
}