class Solution {
    public String pushDominoes(String s) {
        s = "L" + s + "R";
        StringBuilder result = new StringBuilder();
        int prev = 0;
        
        for (int current = 1; current < s.length(); ++current) {
            if (s.charAt(current) == '.') continue;
            
            int span = current - prev - 1;
            
            if (prev > 0)
                result.append(s.charAt(prev));
            
            if (s.charAt(prev) == s.charAt(current)) {
                for (int i = 0; i < span; ++i)
                    result.append(s.charAt(prev));
            } else if (s.charAt(prev) == 'L' && s.charAt(current) == 'R') {
                for (int i = 0; i < span; ++i)
                    result.append('.');
            } else {
                for (int i = 0; i < span / 2; ++i)
                    result.append('R');
                if (span % 2 == 1)
                    result.append('.');
                for (int i = 0; i < span / 2; ++i)
                    result.append('L');
            }
            prev = current;
        }
        return result.toString();
    }
}