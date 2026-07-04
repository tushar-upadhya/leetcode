class Solution {
    public int minScore(int n, int[][] roads) {

        List<List<int[]>> adjusted = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjusted.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adjusted.get(u).add(new int[]{v, w});
            adjusted.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int[] edge : adjusted.get(node)) {
                int nei = edge[0];
                int wt = edge[1];

                ans = Math.min(ans, wt);

                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }

        return ans;
    }
}