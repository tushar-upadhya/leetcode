class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int cost = 0;
        int result = 0;
        
        while (right < n) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));
             while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}