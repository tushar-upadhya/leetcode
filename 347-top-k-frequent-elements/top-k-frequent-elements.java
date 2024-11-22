class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> bucket[] = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int result[] = new int[k];
        int position = 0;

        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int j = 0; j < bucket[i].size() && position < k; j++){
                    result[position] = bucket[i].get(j);
                    position++;
                }
            }
        }
        return result;
    }
}