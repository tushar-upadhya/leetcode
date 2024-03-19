class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char t : tasks)
            map.put(t, map.getOrDefault(t, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue(map.size(), Collections.reverseOrder());
        
        pq.addAll(map.values());
        
        int result = 0;
        while(!pq.isEmpty()){
            int time = 0;
            
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < n + 1; ++i){
                if(!pq.isEmpty()){
                    list.add(pq.remove() - 1);
                    time++;
                }
            }
            for(int t : list)
                if(t > 0) pq.add(t);
            
            result += pq.isEmpty() ? time : n + 1;
        }
        return result;
    }
}