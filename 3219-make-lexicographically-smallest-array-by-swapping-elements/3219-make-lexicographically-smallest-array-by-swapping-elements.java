class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        if (nums.length == 1) {
            return nums;
        }
        int[] smallestArray = new int[nums.length];
        List<Integer> sortedByValue = getSortedByValue(nums);
        int left = 0, right = 1;
        while (right < nums.length) {
            while (right < nums.length && nums[sortedByValue.get(right)] - nums[sortedByValue.get(Math.max(left, right - 1))] <= limit) {
                right++;
            }
            right--;
            if (left == right) {
                smallestArray[sortedByValue.get(right)] = nums[sortedByValue.get(right)];
            } else {
                putIndicesInOrder(left, right, sortedByValue, nums, smallestArray);
            }
            right++;
            left = right;
        }
        return smallestArray;
    }

    private void putIndicesInOrder(int left, int right, List<Integer> sortedByValue, int[] nums, int[] smallestArray) {
        List<Integer> sortedByIndex = new ArrayList<>(1 + right - left);
        for (int i = left; i <= right; i++) {
            sortedByIndex.add(sortedByValue.get(i));
        }
        Collections.sort(sortedByIndex);
        for (int i = 0; i < sortedByIndex.size(); i++) {
            smallestArray[sortedByIndex.get(i)] = nums[sortedByValue.get(left + i)];
        }
    }

    private List<Integer> getSortedByValue(int[] nums) {
        List<Integer> sortedByValue = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sortedByValue.add(i);
        }
        Collections.sort(sortedByValue, Comparator.comparingInt(a -> nums[a]));
        return sortedByValue;
    }
}