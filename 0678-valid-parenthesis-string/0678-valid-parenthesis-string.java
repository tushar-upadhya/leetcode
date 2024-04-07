class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> brackets = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char bracket = s.charAt(i);
            
            if(bracket == '('){
                brackets.push(i);
            }
            else if(bracket == '*'){
                stars.push(i);
            }
            else if(!brackets.isEmpty()){
                brackets.pop();
            }
            else if(!stars.isEmpty()){
                stars.pop();
            }
            else {
                return false;
            }
        }
        while(!brackets.isEmpty() && !stars.isEmpty() && brackets.peek() < stars.peek()){
            brackets.pop();
            stars.pop();
        }
        return brackets.isEmpty();
    }
}