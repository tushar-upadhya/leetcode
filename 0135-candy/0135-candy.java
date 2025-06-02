class Solution {
    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        int right[] = new int[ratings.length];

        left[ratings.length - 1] = 1;
        right[0] = 1;

        for(int i = 1; i < ratings.length; i++){
            right[i] = ratings[i] > ratings[i - 1] ? right[i - 1] + 1 : 1;
        }

        for(int i = ratings.length - 2; i >= 0; i--){
            left[i] = ratings[i] > ratings[i + 1] ? left[i + 1] + 1 : 1; 
        }

        int count = 0;

        for(int i = 0; i < ratings.length; i++){
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}