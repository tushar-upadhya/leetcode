class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int count[] = new int[score.length];
        
        for(char ch : letters){
            count[ch - 'a']++;
        }
        return helper(words, count, score, 0);
    }
    
    private static int helper(String words[], int count[], int score[], int index){
        if(index == words.length) return 0;
        
        int notTake = 0 + helper(words, count, score, index + 1);
        int sword = 0;
        String word = words[index];
        boolean flag = true;
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            
            if(count[ch - 'a'] == 0){
                flag = false;
            }
            
            count[ch - 'a']--;
            sword += score[ch - 'a'];
        }
        int take = 0;
        
        if(flag) take = sword + helper(words, count, score, index + 1);
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            count[ch - 'a']++;
        }
        return Math.max(take, notTake);
    }
}