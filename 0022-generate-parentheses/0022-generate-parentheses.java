class Solution {
    LinkedList<String> list;
    int size = 0;
    
    public List<String> generateParenthesis(int n) {
        list = new LinkedList<>();
        size = 2 * n;
        helper(new char[size], 0, 0, 0);

        return list;
    }

    private void helper(char arr[], int curr, int open, int close){
        if(close > open) return;
        if(curr == size){
            String str = new String(arr);

            if(open == close) list.add(str);
            return;
        }
        arr[curr] = '(';
        helper(arr, curr + 1, open + 1, close);

        arr[curr]= ')';
        helper(arr, curr + 1, open, close + 1);
    }
}