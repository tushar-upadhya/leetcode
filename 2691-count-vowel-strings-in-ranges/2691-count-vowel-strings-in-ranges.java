class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int count = 0;
        int countVowelsInRange[] = new int[m];
        int prefixSum[] = new int[n];
        HashSet<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
      
        for (int i = 0; i < n; i++) {
            String currWord = words[i];
            if (vowels.contains(currWord.charAt(0)) && vowels.contains(currWord.charAt(currWord.length() - 1)))
                count++;
            prefixSum[i] = count;
        }

        for (int i = 0; i < m; i++) {
           
            int start = queries[i][0];
            int end = queries[i][1];
            if (start > 0) {
                countVowelsInRange[i] = prefixSum[end] - prefixSum[start - 1];
            } else {
                countVowelsInRange[i] = prefixSum[end];
            }
        }
        return countVowelsInRange;
    }
}