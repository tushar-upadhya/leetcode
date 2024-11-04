class Solution {
    public String compressedString(String word) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb  = new StringBuilder();
        if (word.length() > 0) stack.push(word.charAt(0));
        
        for (int i = 1 ; i < word.length() ; i++) {
            if (stack.isEmpty() || (stack.peek() == word.charAt(i) && stack.size() < 9)) {
                stack.push(word.charAt(i));
            } else {
                sb.append(String.valueOf(stack.size())).append(stack.pop());        
                stack.clear();
                stack.push(word.charAt(i));
            }
        }
        if (!stack.isEmpty()) {
            sb.append(String.valueOf(stack.size())).append(stack.pop());        
        }
        return sb.toString();
    }
}