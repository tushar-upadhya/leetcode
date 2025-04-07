class Solution {

    public void helper(int[][] grid, int sr, int sc, int newcolor){

            int oldcolor = grid[sr][sc];
            if(oldcolor==newcolor){
                return;
            }
            int n = grid.length;
            int m = grid[0].length;

            Stack<int[]> stack= new Stack<>();
            stack.add(new int[]{sr, sc});

            while(!stack.isEmpty()){
                int current[] = stack.pop();
                int cr = current[0];
                int cc = current[1];
                grid[cr][cc] = newcolor;

                for(int delrow = -1; delrow <= 1; delrow++){
                    for(int delcol = -1; delcol <= 1; delcol++){
                        if(Math.abs(delrow) + Math.abs(delcol) != 1){
                            continue;
                        }
                        int nrow = cr + delrow;
                        int ncol = cc + delcol;
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == oldcolor){
                            stack.add(new int[]{nrow, ncol});
                        }
                    }
                }

            }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int result[][] = image;
        
        helper(result, sr, sc, color);
        
        return result;
    }
}