class Solution {
    private int n;
    private int dp[][] = new int[100001][3];

    private int binarySearch(int events[][], int endTime){
        int left = 0;
        int right = n - 1;
        int result = n;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(events[mid][0] > endTime){
                result = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }

    private int helper(int events[][], int i, int count){
        if(count == 2 || i >= n){
            return 0;
        }
        if(dp[i][count] != -1){
            return dp[i][count];
        }

        int nextValid = binarySearch(events, events[i][1]);
        int take = events[i][2] + helper(events, nextValid, count + 1);
        int notTake = helper(events, i + 1, count);

        dp[i][count] = Math.max(take, notTake);
        return dp[i][count];
    }

    public int maxTwoEvents(int[][] events) {
        n = events.length;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return helper(events, 0, 0);
    }
}