class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char i : s.toCharArray())
            if (i == '[')
                stack.push(i); 
            else if (!stack.isEmpty() && stack.peek() == '[')
                stack.pop(); 
            else
                stack.push(i);
        
        int unbalancedPairs = stack.size() / 2;
        int swaps = (int) Math.ceil(unbalancedPairs / 2.0);
        return swaps;
    }
}