class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); // Clone the prices array for result

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] -= prices[j];
                    break; // Exit inner loop after applying the discount
                }
            }
        }

        return result;
    }
}