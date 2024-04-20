class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;        
        ArrayList<int[]> result = new ArrayList<>();
        boolean visited[][] = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    result.add(bfs(i, j, m, n, visited, land));
                } 
            }
        }
        
        int returned[][] = new int[result.size()][4];
        for(int i = 0; i < result.size(); i++){
            returned[i] = result.get(i);
        }
        return returned;
    }

    public int[] bfs(int i,int j,int m,int n,boolean[][] visited,int[][] land){
        int dr[] = {1,0};
        int dc[] = {0,1};
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{i,j});
        
        int er = 0;
        int ec = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                
                int cell[] = q.poll();
                er = cell[0];
                ec = cell[1];
                
                for(int k = 0; k < 2; k++){
                    int nr = cell[0] + dr[k];
                    int nc = cell[1] + dc[k];
                    
                    if(nr >= 0 && nr < m && nc >= 0 && nc<n && !visited[nr][nc] && land[nr][nc] == 1){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return new int[]{i, j, er, ec};
        
    }
}