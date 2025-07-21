class Solution {
    public String makeFancyString(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int count = 0;
        stack.push(s.charAt(0));
        count++;

        for(int i = 0; i < n - 1; i++){
            if(!stack.isEmpty() && s.charAt(i + 1) == stack.peek()){
                stack.push(s.charAt(i + 1));
                count++;

                if(count >= 3){
                    stack.pop();
                }
            }else if(!stack.isEmpty() && s.charAt(i + 1) != stack.peek()){
                stack.push(s.charAt(i + 1));
                count = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}