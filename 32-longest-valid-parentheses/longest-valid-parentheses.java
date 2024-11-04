class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(-1);
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('|| s.charAt(i) == '{'|| s.charAt(i) == '['){
                stack.push(i);
            }else{   
                if(!stack.isEmpty()){
                  stack.pop();
                  if(!stack.isEmpty()){
                    max = Math.max(i - stack.peek(), max);
                  }else{
                    stack.push(i);
                  }
                }
            }
        }
        return max;
    }
}