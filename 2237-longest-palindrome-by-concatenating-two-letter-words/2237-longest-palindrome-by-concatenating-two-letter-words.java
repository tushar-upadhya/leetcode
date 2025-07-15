class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        int result = 0;

        for(String word : words){
            String rev = new StringBuilder(word).reverse().toString();

            if(freq.getOrDefault(rev, 0) > 0){
                result += 4;
                freq.put(rev, freq.get(rev) - 1);
            }else{
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        
        for(HashMap.Entry<String, Integer> entry : freq.entrySet()){
            String word = entry.getKey();
            int count = entry.getValue();

            if(word.charAt(0) == word.charAt(1) && count > 0){
                result += 2;
                break;
            }
        }
        return result;
    }
}