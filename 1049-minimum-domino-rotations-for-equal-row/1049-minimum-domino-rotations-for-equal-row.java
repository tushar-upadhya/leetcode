class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;

        for(int i = 1; i <= 6; i++){
            result = Math.min(result, helper(tops, bottoms, i));
            result = Math.min(result, helper(bottoms, tops, i));
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int helper(int tops[], int bottoms[], int target){
        int rotations = 0;

        for(int i = 0; i < tops.length; i++){
            if(tops[i] == target) continue;
            if(bottoms[i] == target) rotations++;
            else
            return Integer.MAX_VALUE;
        }
        return rotations;
    }
}