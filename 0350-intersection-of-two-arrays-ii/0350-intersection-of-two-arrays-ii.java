class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int freq1[] = helper(nums1);
        int freq2[] = helper(nums2);

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < freq1.length; i++){
            int count = Math.min(freq1[i], freq2[i]);

            while(count-- > 0){
                ans.add(i);
            }
        }
        int result[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }

    private int[] helper(int[] nums){
        int freq[] = new int[1001];
        for(int element : nums){
            freq[element]++;
        }
        return freq;
    }
}