class Solution {
    int n;
    FenwickTree BIT1, BIT2;
    
    public int[] resultArray(int[] nums) {
        n = nums.length; HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        ArrayList<Integer> arr = new ArrayList<Integer>(set); Collections.sort(arr);
        HashMap<Integer, Integer> compressMap = new HashMap<Integer, Integer>(), reverseMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.size(); i++){
            compressMap.put(arr.get(i), i+1);
            reverseMap.put(i+1, arr.get(i));
        }
        for (int i = 0; i < n; i++){
            nums[i] = compressMap.get(nums[i]);
        }
        ArrayList<Integer> a = new ArrayList<Integer>(), b = new ArrayList<Integer>(); BIT1 = new FenwickTree(n); BIT2 = new FenwickTree(n);
        a.add(nums[0]); b.add(nums[1]); BIT1.update(nums[0], 1); BIT2.update(nums[1], 1); 
        for (int i = 2; i < n; i++){
            int c1 = BIT1.sumRange(nums[i]+1, n), c2 = BIT2.sumRange(nums[i]+1, n);
            if (c1 > c2) {
                a.add(nums[i]); BIT1.update(nums[i], 1);
            }
            else if (c1 < c2){
                b.add(nums[i]); BIT2.update(nums[i], 1);
            }
            else { // c1 == c2
                if (a.size() <= b.size()){
                    a.add(nums[i]); BIT1.update(nums[i], 1);
                }
                else {
                    b.add(nums[i]); BIT2.update(nums[i], 1);
                }
            }
        }
        int[] ret = new int[n];
        for (int i = 0; i < a.size(); i++) ret[i] = reverseMap.get(a.get(i));
        for (int i = a.size(); i < n; i++) ret[i] = reverseMap.get(b.get(i-a.size()));
        return ret;
    }
    
    class FenwickTree {
        int n;
        int[] BIT;

        FenwickTree(int n){
            this.n = n;
            BIT = new int[n+1];
        }

        void update(int idx, int v) {
            for (int i = idx; i <= n; i += i&-i) {
                BIT[i] += v;
            }
        }

        int query(int idx) {
            int ret = 0;
            for (int i = idx; i > 0; i -= i&-i) {
                ret += BIT[i];
            }
            return ret;
        }

        int sumRange(int l, int r) {
            if (r < l) {
                return 0;
            }
            if (l != 0) {
                return query(r) - query(l-1);
            }
            return query(r);
        }
    }
}