class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price in ascending order
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // Update the beauty values to be the maximum beauty at each price point
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }

        List<Integer> result = new ArrayList<>();

        // For each query, use binary search to find the maximum beauty
        for (int price : queries) {
            int maxi = helper(items, price);
            result.add(maxi);
        }

        // Convert the result list to an array and return
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int helper(int items[][], int price) {
        int maxi = 0;
        int left = 0;
        int right = items.length - 1;

        // Binary search to find the maximum beauty for the given price
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (items[mid][0] <= price) {
                maxi = Math.max(maxi, items[mid][1]);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxi;
    }
}
