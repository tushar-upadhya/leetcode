class Solution {
    public int minimumPushes(String word) {
        int arr[] = new int[26];

        for(char c : word.toCharArray()){
            arr[c - 'a']++;
        }   
        Arrays.sort(arr);
        
        int index = 1;
        int sum = 0;
        int count = 1;

        for(int i = 25; i >= 0; i--){
            if(index <= 8){
                index++;
            }else{
                index = 2;
                count++;
            }
            sum = sum + (arr[i] * count);
        }
        return sum;
    }
}