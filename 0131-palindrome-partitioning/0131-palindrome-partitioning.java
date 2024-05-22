class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        
        helper(list, new ArrayList<>(), s);
        
        return list;
    }
    
    private void helper(List<List<String>> list, List<String> temp, String str){
        if(str.length() == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            if(isPalindrome(str.substring(0, i + 1))){
                temp.add(str.substring(0, i + 1));
                
                helper(list, temp, str.substring(i + 1));
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str){
        int n = str.length();
        
        for(int i = 0; i < n / 2; i++){
            if(str.charAt(i) != str.charAt(n - i  - 1)){
                return false;
            }
        }
        return true;
    }
}