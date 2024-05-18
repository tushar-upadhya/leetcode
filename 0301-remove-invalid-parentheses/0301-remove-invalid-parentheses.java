class Solution {
    private ArrayList<String> result = new ArrayList<>();
    private HashSet<String> visited = new HashSet<>();
    
    public List<String> removeInvalidParentheses(String str) {
        helper(str, minValid(str));
        return result; 
    }
    
    public void helper(String str, int valid){
        if(visited.contains(str)) return;

        visited.add(str);
        
        if(valid < 0) return;
        if(valid == 0 && minValid(str) == 0){
                result.add(str);
                return;
        }
        for(int i = 0; i < str.length(); i++){
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            
            helper(left + right, valid - 1);
        }
    }

    public int minValid(String str){
        Stack<Character> st = new Stack<>();
        int start = 0;
       
        while(start < str.length()){
            if(str.charAt(start) == '(') st.push('(');
            else if(str.charAt(start) == ')'){
                if(st.size() > 0 && st.peek() == '(') st.pop();
                else st.push(')');
            }
            start++;
        }
        return st.size();
    }
}