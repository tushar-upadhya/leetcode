class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> wordSet = new HashSet<>();
        int r = board.length;
        int c = board[0].length;
        int maxLen = 0;
        for(String word : words){
            wordSet.add(word);
            maxLen = Math.max(maxLen, word.length()); // Find the word of maximum length.
        }
        Set<String> ans = new HashSet<>();
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                helper(board,wordSet,new boolean[r][c],ans,new StringBuilder(),i,j,r,c,maxLen);
            }
        }
        return new ArrayList<>(ans);
    }

    public void helper(char[][] board,Set<String> wordSet,boolean[][] visited,Set<String> ans, StringBuilder s, int i , int j, int r, int c, int maxLen ){

        

        if(i<0 || j<0 || i==r || j==c || visited[i][j] || s.length() >= maxLen ) return;

        visited[i][j] = true;
        s.append(board[i][j]);

        if(wordSet.contains(s.toString())){
            ans.add(s.toString());
        }

        helper(board,wordSet,visited,ans,s,i+1,j,r,c,maxLen) ;
        helper(board,wordSet,visited,ans,s,i-1,j,r,c,maxLen);
        helper(board,wordSet,visited,ans,s,i,j+1,r,c,maxLen) ;
        helper(board,wordSet,visited,ans,s,i,j-1,r,c,maxLen);
        
        visited[i][j] = false;
        s.setLength(s.length()-1);

    }
}