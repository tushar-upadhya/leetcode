class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] in = new int[n];
        
        // Initializing the path list & adjacency map.
        for(int i = 0; i < n; i++){
            list.add(new HashSet<>());
            map.put(i, new ArrayList<>());
        }
        
        // Processing all the edges. 
        // For each edge add the child to adjacency matrix and incrment it's indegree count.
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            map.get(u).add(v);
            in[v]++;
        }
        
        // Intializing queue & add adding all nodes to with indegree count as zero to queue.
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        
        // perform bfs traversal.
        // we add new node to the queue when its in degree becomes zero.
        while(!q.isEmpty()){
            int node = q.poll();
            for(int child: map.get(node)){
                list.get(child).addAll(list.get(node));
                list.get(child).add(node);
                in[child]--;
                if(in[child] == 0){
                    q.add(child);
                }
            }
        }
        
        // Convert the list into required format.
        List<List<Integer>> result = new ArrayList<>();
        for(Set<Integer> s : list){
            result.add(new ArrayList<>(s));
            Collections.sort(result.get(result.size()-1));
        }
        return result;
    }
}