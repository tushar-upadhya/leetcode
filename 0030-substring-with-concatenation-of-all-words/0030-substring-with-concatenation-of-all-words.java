class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int num = words.length;
        int length = words[0].length();
        
        Map<String, Integer> counts = new HashMap<>();
        
        for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);
        
        List<Integer> indexes = new ArrayList<>();
        
        for (int k = 0; k < length; k++) {
            int left = k;
            int right = k;
            int count = 0;
            
            Map<String, Integer> seen = new HashMap<>();
            
            while (right + length <= n) {
                String word = s.substring(right, right + length);
                right += length;
                
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;
                
                    while (seen.get(word) > counts.get(word)) {
                        String leftWord = s.substring(left, left + length);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += length;
                        count--;
                    } if (count == num) indexes.add(left);
                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return indexes;
    }
}