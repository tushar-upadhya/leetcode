class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int result[] = new int[n];

        for(int i = 0; i < n; i++){
            int count = 0;

            for(int x = 0; x <= i; x++){
                for(int y = 0; y <= i; y++){
                    if(B[y] == A[x]){
                        count++;
                        break;
                    }
                }
            }
            result[i] = count;
        }
        return result;
    }
}