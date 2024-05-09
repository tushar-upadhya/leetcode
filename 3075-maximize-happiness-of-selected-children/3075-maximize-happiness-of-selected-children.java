class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int i = 0;
        int j = n - 1;
        long result = 0;
        
        while(i < k){
            result += Math.max(0, happiness[j] - i);
            i++;
            j--;
        }
        return result;
    }
}