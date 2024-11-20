class Solution {
    public int takeCharacters(String s, int k) {
        int arr[] = new int[3];

        for(char c : s.toCharArray()){
            arr[c - 'a'] += 1;
        }

        if(!helper(arr, k)) return -1;

        int i = 0;
        int j = 0;
        int max = -1;

        while(j < s.length()){
            arr[s.charAt(j) - 'a'] -= 1;

            while(!helper(arr, k)){
                arr[s.charAt(i) - 'a'] += 1;
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return s.length() - max;
    }

    private boolean helper(int arr[], int k){
        return arr[0] >= k && arr[1] >= k && arr[2] >= k;
    }
}