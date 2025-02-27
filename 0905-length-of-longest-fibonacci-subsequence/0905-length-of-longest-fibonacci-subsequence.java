class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            set.add(num);
        }

        int result = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int x = arr[j], y = arr[i] + arr[j];
                int length = 2;

                while(set.contains(y)){
                    int temp = y;
                    y += x;
                    x = temp;

                    result = Math.max(result, ++length);
                }
            }
        }
        return result;
    }
}