class Solution {
    public int maximumLength(int[] nums, int k) {
        int dp[][] = new int[k][k];
        int maxLength = 0;

        for(int num : nums){
            int currentReminder = num % k;

            for(int prevReminder = 0; prevReminder < k; prevReminder++){
                dp[prevReminder][currentReminder] = dp[currentReminder][prevReminder] + 1;

                if(dp[prevReminder][currentReminder] > maxLength){
                    maxLength = dp[prevReminder][currentReminder];
                }
            }
        }
        return maxLength;
    }
}