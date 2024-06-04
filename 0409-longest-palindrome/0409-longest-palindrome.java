class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        int result = 0;
        boolean visited = false;

        for(Character key : map.keySet()){
            if(map.get(key) % 2 == 0){
                result += map.get(key);
            }else{
                result += map.get(key);
                if(!visited){
                    visited = true;
                }else{
                    result -= 1;
                }
            }
        }
        return result;
    }
}