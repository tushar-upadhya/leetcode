class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int i = 0;
        int j = 0;
        StringBuilder res = new StringBuilder();
        
        while(i < n || j < m){
            if(i < word1.length())
                res.append(word1.charAt(i++));
            
            if(j < word2.length())
                res.append(word2.charAt(j++));
        }
        return res.toString();
    }
}