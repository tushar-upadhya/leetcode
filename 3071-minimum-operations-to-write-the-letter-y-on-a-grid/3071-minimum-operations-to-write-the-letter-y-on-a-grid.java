class Solution {   
public int minimumOperationsToWriteY(int[][] grid) {
    int result = Integer.MAX_VALUE;

    for(int i = 0; i < 3; ++i){
        for(int j = 0; j < 3; ++j){
            if(i != j) result = Math.min(result, helper(grid, i,j));
        }
    }
    return result;
}
private int helper(int[][] grid, int y, int notY){
    int result = 0;
    int n = grid.length;
   
       for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if((i <= n / 2 && (i == j || i + j == n - 1)) || (i > n / 2 && j == n / 2)){
                if(y != grid[i][j]) result++;
            }else{
                if(notY != grid[i][j]) result++;
            }
        }
    }
    return result;
    }
}