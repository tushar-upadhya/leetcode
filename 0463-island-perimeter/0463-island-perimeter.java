class Solution {
    int count = 0;
    public int islandPerimeter(int[][] grid) {
        count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j < grid[i].length; j++){
                if(grid[i][j] == 1){
                     helper(grid, i, j);
                     break;
                }
            }
        }
       return count; 
    }
    
    private void helper(int grid[][],int i,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 ){
           count++;
          return;
        }
        if(grid[i][j] == -1)return;
        
        grid[i][j] = -1;
        
        helper(grid, i + 1,j);
        helper(grid, i - 1,j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }
}