class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int total = 0;

        for(int i = 1; i < n - 1; i++){
            int leftLess = 0;
            int rightLess = 0;
            int rightGreater = 0;
            int leftGreater = 0;

            for(int j = i - 1; j >= 0; j--){
                if(rating[i] > rating[j]){
                    leftLess++;
                }else{
                    leftGreater++;
                }
            }

            for(int j = i + 1; j < n; j++){
                if(rating[i] > rating[j]){
                    rightLess++;
                }else{
                    rightGreater++;
                }
            }
            total += leftLess * rightGreater + rightLess * leftGreater;
        }   
        return total;
    }
}