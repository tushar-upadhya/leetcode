class Solution {
    public int numSubmatrixSumTarget(int[][] M, int T) {
        int xlength = M[0].length;
        int ylength = M.length; 
        int ans = 0;
        Map<Integer, Integer> result = new HashMap<>();
        
        for (int[] r : M)
            for (int j = 1; j < xlength; j++)
                r[j] += r[j - 1];
       
        for (int j = 0; j < xlength; j++)
            for (int k = j; k < xlength; k++) {
                
                result.clear();
                result.put(0,1);
                int currentSum = 0;
                
                for (int i = 0; i < ylength; i++) {
                    currentSum += M[i][k] - (j > 0 ? M[i][j - 1] : 0);
                    ans += result.getOrDefault(currentSum - T, 0);
                    result.put(currentSum, result.getOrDefault(currentSum, 0) + 1);
                }
            }
        return ans;
    }
}