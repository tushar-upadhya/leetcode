class Solution {
    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());
        
        for (int[] query : queries) {
            list.get(query[0]).add(query[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count[] = new int[n + 1];
        int dec = 0;

        for (int i = 0; i < n; i++) {
            dec += count[i];
            for (int end : list.get(i)) {
                pq.offer(end);
            }

            int x = nums[i];
            while (x > dec && !pq.isEmpty() && pq.peek() >= i) {
                int k = pq.poll();
                count[k + 1]--;
                dec++;
            }

            if (x > dec) return -1;
        }

        return pq.size();
    }
}