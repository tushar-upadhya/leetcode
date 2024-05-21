class Solution {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(helper(nums, n, mid) > (((long)n*((long)n + 1)) / 2l - 1) / 2l) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public long helper(int[] arr, int n, int k) {
        long count = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0)
                    map.remove(arr[left]);
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}