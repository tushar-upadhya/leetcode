class Solution {
    public int maxMoves(int[][] grid) {
        int maxRow = grid.length - 1;
        int maxCol = grid[0].length - 1;
        int memory[][] = new int[maxRow + 1][maxCol + 1];

        for(int row[] : memory) Arrays.fill(row, -1);
        int result = 0;
        for(int i = 0; i <= maxRow; i++){
            int temp = helper(grid, i, 0, maxRow, maxCol, memory);
            result = Math.max(result, temp);
        }
        return result;
    }

    int helper(int grid[][], int row, int col, int maxRow, int maxCol, int memory[][]){
        if(row < 0 || col > maxCol || row > maxRow) return 0;

        if(memory[row][col] != -1) return memory[row][col];

        int diagonalUP = 0;
        int right = 0;
        int diagonalDOWN = 0;

        if(row - 1 >= 0 && col + 1 <= maxCol && grid[row - 1][col + 1] > grid[row][col]){
            diagonalUP = 1 + helper(grid, row - 1, col + 1, maxRow, maxCol, memory);
        }
        if(col + 1 <= maxCol && grid[row][col + 1] > grid[row][col]){
            right = 1 + helper(grid, row, col + 1, maxRow, maxCol, memory);
        }
        if(row + 1 <= maxRow && col + 1 <= maxCol && grid[row + 1][col + 1] > grid[row][col]) {
            diagonalDOWN = 1 + helper(grid, row + 1, col + 1, maxRow, maxCol, memory);
        }

        return memory[row][col] = Math.max(diagonalUP, Math.max(right, diagonalDOWN));
    }
}