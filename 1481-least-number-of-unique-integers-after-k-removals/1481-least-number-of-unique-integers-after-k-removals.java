class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        List value = new ArrayList(map.values());
        Collections.sort(value);
        
        int count = value.size();
        
        for(Object a : value){
            if((int)a <= k){
                k -= (int)a;
                count--;
            }
            else if(k < (int)a) break;
        }
        return count;
    }
}