class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
            List<List<Integer>> list = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < edges.length; i++){
                list.get(edges[i][0]).add(edges[i][1]);
                list.get(edges[i][1]).add(edges[i][0]);
            }

            int count = 0;
            boolean visited[] = new boolean[n];
            
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    
                    Queue<Integer>  q =new LinkedList<>();
                    q.offer(i);
                    
                    List<Integer>li = new ArrayList<>();

                    visited[i] = true;
                    while(!q.isEmpty()){
                        int x = q.poll();
                        
                        li.add(x);
                        for(int j : list.get(x)){
                            
                            if(!visited[j]){
                                q.offer(j);
                                visited[j] = true;
                            }
                        }
                    }
                    boolean flag = true;
                    for(int j : li){
                        if(list.get(j).size() != li.size() - 1){
                            flag = false;
                            break;
                        }
                    }

                    if(flag) count++;
                }
            }
        return count;
    }
}