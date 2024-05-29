class Solution {
    public long sumDigitDifferences(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        
        int numDigit = String.valueOf(nums[0]).length();
        long[][] digitCount = new long[numDigit][10];
        
        for(int num : nums){
            String str = String.valueOf(num);
            for(int i = 0; i < numDigit; i++){
                digitCount[i][str.charAt(i) - '0']++;
            }
        }
        
        long diff = 0;
        for(int i = 0; i < numDigit; i++){
            for(int j = 0; j < 10; j++){
                long count = digitCount[i][j];
                diff += count*(nums.length - count);
            }
        }
        return diff / 2;
    }
}