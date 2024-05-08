class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        List<List<String>> prevNodes = new ArrayList<>();
        
        if (!dict.contains(endWord)) return result;
        dict.remove(beginWord);
                
        boolean reached = false;
        
        ArrayList<String> temp = new ArrayList<>();
        temp.add(beginWord);        
        prevNodes.add(temp);
        
        
        while (dict.size() > 0 && !reached) {
            
            List<String> last = prevNodes.get(prevNodes.size()-1);
            List<String> current = new ArrayList<>();

            for (int i = 0; i < last.size() && !reached; i++) {
                
                HashSet<String> visited = new HashSet<>(); 
                String from = last.get(i); 

                for(String to : dict){                     
                    if(visited.contains(to) || !helper(from, to))continue;                    
                    if(to.equals(endWord)){
                        reached = true;
                        break;
                    }                    
                    current.add(to);
                    visited.add(to);
                }
                for(String node : visited)
                    dict.remove(node);
            }            
            if (reached || current.size() < 1) break;                 
            prevNodes.add(current);
        }        
        
        if (!reached) 
            return result;
			
        ArrayList<String> end = new ArrayList<>();
        end.add(endWord);    
        result.add(end);        

        for (int level = prevNodes.size() - 1; level >= 0; level--) {             
            int alen = result.size();
			
            while (alen-- > 0) {                
                List<String> path = result.get(0);
                result.remove(0);                
                String from = path.get(0);  
				
                for (String word : prevNodes.get(level)) {                    
                    if (!helper(word, from)) continue; 

                    List<String> newPath = new ArrayList<String>();                    
                    newPath.add(word);

                    for(String str2 : path){
                        newPath.add(str2);
                    }                    
                    result.add(newPath);                    
                }                
            }             
        }
        return result;        
    }
    
    private boolean helper(String str, String str2){
        int count = 0;

        for(int i = 0; count < 2 && i < str.length(); i++){
            if(str.charAt(i) != str2.charAt(i))
                count++;
        }
        return count == 1;
    }
    
}