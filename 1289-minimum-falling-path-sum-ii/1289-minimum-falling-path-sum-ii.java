class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        
        for(int row = n - 2;  row >= 0; row--){
            for(int col = 0; col < n; col++){
                int min = Integer.MAX_VALUE;
                
                for(int k = 0; k < col; k++){
                    min = Math.min(grid[row + 1][k], min);
                }
                
                for(int k = col + 1; k < n; k++){
                    min = Math.min(grid[row + 1][k], min);
                }
                
                grid[row][col] += min;
            }
        }
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            result = Math.min(result, grid[0][i]);
        }
        return result;
    }
}