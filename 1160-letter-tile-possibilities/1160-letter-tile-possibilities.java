class Solution {
    public int numTilePossibilities(String tiles) {
        return helper(new StringBuilder(tiles)) - 1;
    }

    private int helper(StringBuilder s){
        if(s.length() == 1) return 2;

        int count = 1;
        int freq[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(freq[c - 'A'] == 0){
                freq[c - 'A'] = 1;

                char x = s.charAt(i);
                s.deleteCharAt(i);
                count += helper(s);
                s.insert(i, x);
            }
        }
        return count;
    }
}