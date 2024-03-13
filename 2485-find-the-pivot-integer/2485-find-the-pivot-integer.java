class Solution {
       public int pivotInteger(int n) {
        int rightSum = n * (n + 1) / 2;
        for (int i = 1, leftSum = 0; i <= n; ++i) {
            rightSum -= i;
            if (leftSum == rightSum) {
                return i;
            }else if (leftSum > rightSum) {
                return -1;
            }
            leftSum += i;
        }
        return -1;
    }
}