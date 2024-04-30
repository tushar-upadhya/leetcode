class Solution {
    public long wonderfulSubstrings(String word) {
        long result = 0;
        int bits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        for(char c : word.toCharArray()){
            bits ^= 1 <<(c - 'a');
            
            int occ = map.getOrDefault(bits, 0);
            map.put(bits, occ + 1);
            
            result += occ;
            
            for(int i = 0; i < 11; i++){
                result += map.getOrDefault(bits ^ (1 << i), 0);
            }
        }
        return result;
    }
}