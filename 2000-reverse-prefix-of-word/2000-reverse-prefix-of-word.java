class Solution {
    public String reversePrefix(String word, char ch) {
        char c[] = word.toCharArray();
        int n = 0;
        
        for(int i = 0; i < word.length(); i++){
            if(ch == c[i]){
                n = i;
                break;
            }
        }
        char result[] = new char[word.length()];
        for(int i = 0; i <= n; i++){
            result[i] = c[n - i];
        }
        for(int i = n + 1; i < word.length(); i++){
            result[i] = c[i];
        }
        return String.valueOf(result);
    }
}