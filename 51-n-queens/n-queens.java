class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n;i++)
            for(int j = 0; j < n; j++)
                board[i][j]='.';
        List<List<String>> result = new ArrayList();

        dfs(0,board,result);
        
        return result; 
    }

    private static boolean validate(char[][] board, int row, int col){
        int duprow = row;
        int dupcol = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        while(col >= 0 && row < board.length){
            if(board[row][col ]== 'Q') return false;
            col--;
            row++;
        }

        return true;
    }
    
    private static void dfs(int col, char[][] board, List<List<String>> result){
        if(col == board.length){
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(validate(board, row, col)){
                board[row][col] = 'Q';
                dfs(col + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private static List<String> construct(char[][] board){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < board.length; i++){
            String str = new String(board[i]);
            result.add(str);
        }

        return result;
    }
}