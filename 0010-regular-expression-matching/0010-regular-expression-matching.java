class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0, new Boolean[m + 1][n]);
    }

    private boolean isMatch(char[] s, char[] p, int sIndex, int pIndex, Boolean[][] memo) {
        // both the pointers have reached the end of their strings.
        if(sIndex == s.length && pIndex == p.length) return true;
        
        // if you run out of pattern to compare the sentence with.
        if(pIndex == p.length) return false;

        // have we seen this state before ? 
        if(memo[sIndex][pIndex] != null) return memo[sIndex][pIndex];

        // can you ignore the current character ? 
        if(canIgnore(p, pIndex) && isMatch(s, p, sIndex, pIndex + 1, memo)) {
            return memo[sIndex][pIndex] = true;
        }

        // can we repeat the previous character
        if(p[pIndex] == '*') {
            // repeating 0 times or ignoring
            if(isMatch(s, p, sIndex, pIndex + 1, memo)) {
                return memo[sIndex][pIndex] = true;
            }
            
            // try every different possiblility of repeating the prev character
            char prev = p[pIndex - 1];
            int index = sIndex;
            while(index < s.length && (prev == '.' || prev == s[index])) {
                if(isMatch(s, p, index + 1, pIndex + 1, memo)) return memo[index][pIndex] = true;
                index++;
            }

            // if this is an invalid state
            return memo[sIndex][pIndex] = false;
        }

        // if you run out of sentence to match with pattern
        if(sIndex == s.length) return false;

        // match with any character
        if(p[pIndex] == '.' && isMatch(s, p, sIndex + 1, pIndex + 1, memo)) {
            return memo[sIndex][pIndex] = true;
        }

        // match the current character.
        if(s[sIndex] == p[pIndex] && isMatch(s, p, sIndex + 1, pIndex + 1, memo)) {
            return memo[sIndex][pIndex] = true;
        }

        // invalid result
        return memo[sIndex][pIndex] = false;
    }

    private boolean canIgnore(char[] pattern, int index) {
        return index < pattern.length - 1 && pattern[index + 1] == '*';
    }
}