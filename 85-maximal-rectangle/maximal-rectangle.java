class Solution {
    public int maximalRectangle(char[][] matrix) {
        int prefixSum[][] = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix[0].length; i++){
            int count = 0;

            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] == '1'){
                    count++;
                }else{
                    count = 0;
                }
                prefixSum[j][i] = count;
            }
        }
        int max = 0;

        for(int i = 0; i < prefixSum.length; i++){
            Stack<Integer> stack = new Stack<>();

            for(int j = 0; j < prefixSum[i].length; j++){
                while(!stack.isEmpty() && prefixSum[i][stack.peek()] >= prefixSum[i][j]){
                    int nse = j;
                    int val = prefixSum[i][stack.pop()];
                    int pse = stack.isEmpty() ? - 1 : stack.peek();

                    max = Math.max(max, val * (nse - pse - 1));
                }
                stack.push(j);
            }
            while(!stack.isEmpty()){
                int nse = prefixSum[i].length;
                int val = prefixSum[i][stack.pop()];
                int pse = stack.isEmpty() ? - 1 : stack.peek();

                max = Math.max(max, val * (nse - pse - 1));
            }
        }
        return max;
    }
}