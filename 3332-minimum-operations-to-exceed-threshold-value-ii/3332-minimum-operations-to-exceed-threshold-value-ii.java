class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // add all elements to the pq
        for(int num : nums){
            pq.add((long)num);
        }
        int count = 0;

        while(!pq.isEmpty() && pq.peek() < k){
            long smallest = pq.poll();
            long secondSmallest = pq.poll();

            pq.add(smallest * 2 + secondSmallest);
            count++;
        }
        return count;
    }
}