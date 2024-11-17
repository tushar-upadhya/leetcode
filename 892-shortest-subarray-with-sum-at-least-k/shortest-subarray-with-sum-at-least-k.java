import java.util.PriorityQueue;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        long sum = 0;
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum >= k) {
                result = Math.min(result, i + 1);
            }

            while (!pq.isEmpty() && sum - pq.peek()[0] >= k) {
                result = Math.min(result, (int)(i - pq.poll()[1]));
            }

            pq.offer(new long[] {sum, i});
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}