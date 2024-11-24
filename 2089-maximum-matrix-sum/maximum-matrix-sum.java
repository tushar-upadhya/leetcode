class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;   
        int m = matrix[0].length;
        long sum = 0;
        int count = 0;
        int smallest = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sum += Math.abs(matrix[i][j]);

                if(matrix[i][j] < 0){
                    count++;
                }
                smallest = Math.min(smallest, Math.abs(matrix[i][j]));
            }
        }   
        if(count % 2 == 0){
            return sum;
        }
        return sum - 2L * smallest;
    }
}