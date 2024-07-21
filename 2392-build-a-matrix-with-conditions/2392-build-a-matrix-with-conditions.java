class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int result[][] = new int[k][k];
        int sortedRow[] = helper(rowConditions, k);
        int sortedCol[] = helper(colConditions, k);
        if (sortedRow.length * sortedCol.length == 0) return new int[0][0];

        for(int i = 1; i <= k; i++)
            result[sortedRow[i - 1]][sortedCol[i - 1]] = i;

        return result;
    }

    private int[] helper(int[][] rowConditions, int k){
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= k; i++) set.add(i);

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] counter = new int[k]; 
        for (int[] v : rowConditions) {
            List<Integer> list = map.getOrDefault(v[0], new ArrayList<>());
            
            map.put(v[0], list);
            list.add(v[1]);
            counter[v[1] - 1]++;
            set.remove(v[1]);
        }

        int result[] = new int[k];
        Queue<Integer> q = new LinkedList<>(set);
        int index = 0;

        while (!q.isEmpty()) {
            int value = q.poll();

            result[value - 1] = index++;
            if (map.containsKey(value)) {
                List<Integer> list = map.get(value);

                for (int nextValue : list) {
                    counter[nextValue - 1]--;
                    if (counter[nextValue - 1] == 0) q.add(nextValue);
                }
            }
        }

        if (index != k) return new int[0];
        return result;
    }
}