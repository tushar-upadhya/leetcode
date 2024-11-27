class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i <= n - 2; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i + 1);
            map.put(i, list);
        }

        int result[] = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int query[] = queries[i];
            int start = query[0];
            int end = query[1];

            List<Integer> list = map.get(start);
            list.add(end);
            map.put(start, list);
            result[i] = helper(map, n);
        }
        return result;
    }

    private int helper(Map<Integer, List<Integer>> map, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int distance[] = new int[n];

        for(int i = 0; i < distance.length; i++){
            distance[i] = -1;
        }
        distance[0] = 0;

        while(!q.isEmpty()){
            int value = q.poll();
            if(value == n - 1){
                break;
            }
            List<Integer> neighbors = map.get(value);

            for(int i = 0; i < neighbors.size(); i++){
                if(distance[neighbors.get(i)] == -1){
                    distance[neighbors.get(i)] = distance[value] + 1;
                    q.add(neighbors.get(i));
                }
            }
        }
        return distance[n - 1];
    }
}