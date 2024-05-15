class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int row = grid.size();
        int col = grid.get(0).size();
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid.get(i).get(j) == 1){
                    if((i == 0 && j == 0) || (i == row - 1 && j == col - 1)){
                        return 0;
                    }
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] distance = new int[row][col];

        bfs(row, col, q, distance, directions, visited);
        
        return helper(0, 0, directions, distance, row, col);
    }

    private void bfs(int row, int col, Queue<int[]> q, int[][] distance, int[][] directions, boolean[][] visited){
        while(!q.isEmpty()){
           
            int size = q.size();
           
            for(int i = 0; i < size; i++){
                int[] current = q.poll();
                int currentX = current[0];
                int currentY = current[1];
                int currentDistance = current[2];
           
                for(int[] dir : directions){
                    int nextX = currentX + dir[0];
                    int nextY = currentY + dir[1];
           
                    if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = currentDistance + 1;
                        q.offer(new int[]{nextX, nextY, currentDistance + 1});
                    }
                }
            }
        }
    }

    private int helper(int row, int col, int[][] directions, int[][] distance, int rows, int cols){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[2] == b[2]){
                    return 0;
                }
                return a[2] > b[2] ? -1 : 1;
            }
        });
        pq.offer(new int[]{row, col, distance[row][col]});
        
        boolean[][] visited = new boolean[distance.length][distance[0].length];
        
        visited[row][col] = true;
        
        while(!pq.isEmpty()){
            int size = pq.size();
        
            for(int i = 0; i < size; i++){
                int[] current = pq.poll();
                int currentX = current[0];
                int currentY = current[1];
                int currentDistance = current[2];
        
                if(currentX == distance.length - 1 && currentY == distance[0].length - 1){
                    return currentDistance;
                }
        
                for(int[] dir : directions){
                    int nextX = currentX + dir[0];
                    int nextY = currentY + dir[1];
        
                    if(nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        pq.offer(new int[]{nextX, nextY, Math.min(currentDistance, distance[nextX][nextY])});
                    }
                }
            }
        }
        return -1;
    }
}