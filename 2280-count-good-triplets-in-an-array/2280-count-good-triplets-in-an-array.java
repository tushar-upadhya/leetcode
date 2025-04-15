class Solution {
    private int helper(List<Integer> nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) == target) {
                return mid;
            }
            if (nums.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        long count = 0;
        int n = nums1.length;
        int indexMap[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            indexMap[nums1[i]] = i;
        }
        int prem[] = new int[n];
        for (int i = 0; i < n; i++) {
            prem[i] = indexMap[nums2[i]];
        }
        int[] leftSmaller = new int[n];
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = helper(sortedList, prem[i]);
            leftSmaller[i] = index;
            sortedList.add(index, prem[i]);
        }
        int[] rightGreater = new int[n];
        sortedList.clear();
        for (int i = n - 1; i >= 0; i--) {
            int index = helper(sortedList, prem[i]);
            rightGreater[i] = sortedList.size() - index;
            sortedList.add(index, prem[i]);
        }
        for (int i = 0; i < n; i++) {
            count += (long) leftSmaller[i] * rightGreater[i];
        }
        return count;
    }
}