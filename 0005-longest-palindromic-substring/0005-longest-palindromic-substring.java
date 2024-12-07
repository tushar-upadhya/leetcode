class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }    
        int maxi = 1;
        String str = s.substring(0, 1);

        for(int i = 0; i < s.length(); i++){
            for(int j = i + maxi; j <= s.length(); j++){
                if(j - i > maxi && helper(s.substring(i, j))){
                    maxi = j - i;
                    str = s.substring(i, j);
                }
            }
        }
        return str;
    }

    private boolean helper(String str){
        int left = 0;
        int right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}