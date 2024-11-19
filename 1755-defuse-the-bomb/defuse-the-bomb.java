class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int arr[] = new int[n];
        
        if (k == 0) {
            return arr;
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int j = 1; j <= k; j++) {
                    s += code[(i + j) % n];
                }
                arr[i] = s;
            }
        } else if (k < 0) {
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int j = 1; j <= -1 * k; j++) {
                    s += code[(i - j + n) % n];
                }
                arr[i] = s;
            }
        }
        return arr;
    }
}