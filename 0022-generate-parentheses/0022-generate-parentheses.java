class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        if(n == 0){
            return result;
        }
        helper(result, "", n, n);
        
        return result;
    }
    
    private void helper(List<String> result, String present, int left, int right){
        if(right == 0){
            result.add(present);
        }
        
        if(left > 0){
            helper(result, present + "(" , left - 1, right);
        }
        
        if(right > left){
            helper(result, present + ")" , left, right - 1);
        }
    }
}