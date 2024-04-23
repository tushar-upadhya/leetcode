class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Collections.singletonList(0);
        }
        
        List<Set<Integer>> setList = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            setList.add(new HashSet<>());
        }
        
        for(int e[] : edges){
            setList.get(e[0]).add(e[1]);
            setList.get(e[1]).add(e[0]);            
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(setList.get(i).size() == 1){
                list.add(i);
            }
        }
        while(n > 2){
            n -= list.size();
            
            List<Integer> newList = new ArrayList<>();
            for(int l : list){
                int j = setList.get(l).iterator().next();
                setList.get(j).remove(l);
                
                if(setList.get(j).size() == 1){
                    newList.add(j);
                }
            }
            list = newList;
        }
        return list;
    }
}