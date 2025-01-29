class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(adj.containsKey(u) && adj.containsKey(v)){
                boolean visited[] = new boolean[n + 1];

                if(helper(adj, u, v, visited)){
                    return edge;
                }
            }

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
    private boolean helper(Map<Integer, List<Integer>> adj, int u, int v, boolean[] visited) {
        visited[u] = true;
        if (u == v) {
            return true;
        }
        for (int ngbr : adj.get(u)) {
            if (visited[ngbr]) continue;
            if (helper(adj, ngbr, v, visited)) {
                return true;
            }
        }
        return false;
    }
}


// T.C : O(n^2)
// S.C : O(n)