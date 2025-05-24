class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer> adj[] = new List[n];
        int indegree[] = new int[n];
        List<Integer> result = new ArrayList<>();

        for(int pair[] : prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];

            if(adj[prerequisite] == null){
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();
            result.add(current);

            if(adj[current] != null){
                for(int next : adj[current]){
                    indegree[next]--;

                    if(indegree[next] == 0){
                        q.offer(next);
                    }
                }
            }
        }
        return result.size() == n;
    }
}