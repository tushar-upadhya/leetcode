class Solution {
    public long maximumTripletValue(int[] nums) {
        long result = 0;
        int maxi = 0;
        int imaxi = 0;

        for(int i : nums){
            result = Math.max(result, ((long)maxi * (long)i));
            maxi = Math.max(maxi, imaxi - i);
            imaxi = Math.max(imaxi, i);
        }
        return result;
    }
}