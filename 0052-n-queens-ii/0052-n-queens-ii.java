class Solution {
    int count = 0;
    
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){
                board[i][j]='.';
            }
        }
        boardgenerater(board, 0, n);

        return count;
    }

    public boolean boardgenerater(char[][] board,int col, int n){
        if(col == n){
            count++;
            return false;

        }
        
        for(int i = 0; i < n; i++){
            
            if(issafe(board, i, col, n)){
                board[i][col] = 'Q';
               
               if(boardgenerater(board, col + 1, n)){
                   return true;
               }else{
                   board[i][col]='.';
               }
            }
        }
        return false;
    }

    public boolean issafe(char[][] board, int row, int col, int n){
        int x = row;
        int y = col;

        for(int i = 0; i < n; i++){

            if(board[i][col] == 'Q'){
                return false;
            }

            if(board[row][i] == 'Q'){
                return false;
            }

        }

        while(x < n && y >= 0){
            
            if(board[x][y] == 'Q'){
                return false;
            }
            x++;
            y--;
        }

        while(row >= 0 && col >= 0){
            
            if(board[row][col] =='Q'){
                return false;
            }
            row--;
            col--;
        }
        return true;
    }
}