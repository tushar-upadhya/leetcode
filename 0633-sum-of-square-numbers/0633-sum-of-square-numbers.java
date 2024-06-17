class Solution {
    public boolean judgeSquareSum(int c) {
        long start = 0;
        long end = (long)Math.sqrt(c);

        while(start <= end){
            long mid = start * start + end * end;

            if(mid == (long)c){
                return true;
            }else if(mid > (long)c){
                end--;
            }else{
                start++;
            }
        }
        return false;
    }
}