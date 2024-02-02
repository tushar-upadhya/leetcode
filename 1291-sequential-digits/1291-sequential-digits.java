class Solution {
   public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();
        
       for (int i = 1; i <= 9; i++) {
            helper(0, i, low, high, result);
        }
        Collections.sort(result);
        return result;
    }
    
    private void helper(int cur, int digit, int low, int high, List<Integer> result) {    
        cur = cur * 10 + digit;
        if (cur > high)
            return;
        
        if (cur >= low) {
            result.add(cur);
        }
        
        if (digit + 1 <= 9)
            helper(cur, digit + 1, low, high, result);
    }
}