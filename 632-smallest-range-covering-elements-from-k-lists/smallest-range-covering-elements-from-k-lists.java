class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            currentMax = Math.max(currentMax, nums.get(i).get(0));
        }
        
        int[] smallRange = new int[]{0, Integer.MAX_VALUE};

        while (true) {
            int[] current = pq.poll();
            int currentMin = current[0];
            int listIndex = current[1];
            int elemIndex = current[2];

            if (currentMax - currentMin < smallRange[1] - smallRange[0]) {
                smallRange[0] = currentMin;
                smallRange[1] = currentMax;
            }

            if (elemIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elemIndex + 1);
                pq.offer(new int[]{nextVal, listIndex, elemIndex + 1});
                currentMax = Math.max(currentMax, nextVal);
            } else {
                break;
            }
        }
        return smallRange;
    }
}