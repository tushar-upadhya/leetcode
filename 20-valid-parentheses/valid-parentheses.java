class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char c = stack.peek();
                stack.pop();
                if((s.charAt(i) == ')' && c == '(') || (s.charAt(i) == '}' && c == '{') || (s.charAt(i) == ']' && c == '[')){
                    continue;
                }else{
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}