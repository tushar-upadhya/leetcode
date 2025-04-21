class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int current = 0;
        int minVal = 0;
        int maxVal = 0;

        for(int d : differences){
            current += d;
            minVal = Math.min(minVal, current);
            maxVal = Math.max(maxVal, current);

            if((upper - maxVal) - (lower - minVal) + 1 <= 0){
                return 0;
            }
        }
        return (upper - maxVal) - (lower - minVal) + 1;
    }
}