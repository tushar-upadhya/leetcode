class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] list = new ArrayList[n];

        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            list[u].add(v);
            list[v].add(u);
        }


        int[] countArr = new int[n];
        countNodes(list, 0, countArr, new boolean[n]);

        int[] distance = new int[n];

        distance[0] = rootDistance(list, 0, countArr, new boolean[n]);

        calDistances(list, 0, countArr, new boolean[n], distance);

        return distance;
    }

    private int countNodes(ArrayList<Integer>[] list, int src, int[] countArr, boolean[] vis){
        vis[src] = true;
        int c = 1;
        for(int nbr : list[src]){
            if(vis[nbr]==false){
                c += countNodes(list, nbr, countArr, vis);
            }
        }
        countArr[src] = c;
        return c;
    }

    private int rootDistance(ArrayList<Integer>[] list, int src, int[] countArr, boolean[] vis){
        vis[src] = true;
        int dist = 0;
        for(int nbr : list[src]){
            if(vis[nbr]==false){
                dist += rootDistance(list, nbr, countArr, vis) + countArr[nbr];
            }
        }
        return dist;
    }

    private void calDistances(ArrayList<Integer>[] list, int src, int[] countArr, boolean[] vis, int[] distance){
        vis[src] = true;
        for(int nbr : list[src]){
            if(vis[nbr] == false){
                distance[nbr] = distance[src] + list.length - 2 * countArr[nbr];
                calDistances(list, nbr, countArr, vis, distance);
            }
        }
    }
}