class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        long totalZero1 = 0;
        long totalZero2 = 0;

        for(int num : nums1){
            sum1 += num;

            if(num == 0){
                sum1++;
                totalZero1++;
            }
        }

        for(int num : nums2){
            sum2 += num;

            if(num == 0){
                sum2++;
                totalZero2++;
            }
        }

        if((totalZero1 == 0 && sum2 > sum1) || (totalZero2 == 0 && sum1 > sum2)){
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}