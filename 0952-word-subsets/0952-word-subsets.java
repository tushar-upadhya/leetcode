class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int freq[] = new int[26];
        
        // Compute the maximum frequency requirement for words2
        for(String word : words2){
            int temp[] = helper(word);

            for(int i = 0; i < 26; i++){
                freq[i] = Math.max(freq[i], temp[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for(String word : words1){
            int temp[] = helper(word);

            boolean isValid = true;

            for(int i = 0; i < 26; i++){
                if(temp[i] < freq[i]){
                    isValid = false;
                    break;
                }
            }
            if(isValid) result.add(word);
        }
        return result;
    }

    // Filter words1 based on frequency requirements
    private int[] helper(String s){
        int freq[] = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        return freq;
    }
}