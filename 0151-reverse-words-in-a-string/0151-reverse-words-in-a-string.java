class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        String result = "";

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(temp.length() > 0) stack.push(temp);
                temp ="";
            }else
            temp = temp + s.charAt(i);
        }
        result = result + temp;

        while(!stack.isEmpty()){
            result = result + " " + stack.pop();
        }
        if(result.length() != 0 && result.charAt(0) == ' ') result = result.substring(1);

        return result;
    }
}