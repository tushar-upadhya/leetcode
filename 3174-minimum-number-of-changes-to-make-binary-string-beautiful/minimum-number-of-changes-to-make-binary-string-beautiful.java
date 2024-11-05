class Solution {
    public int minChanges(String s) {
        int result = 0;
        int prev = 0;

        for(int current = 0; current < s.length(); current++){
            if(s.charAt(prev) != s.charAt(current)){
                if((current - prev) % 2 == 0){
                    prev = current;
                }else{
                    result++;
                    current++;
                    prev = current;
                }
            }
        }
        return result;
    }
}