class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] championExist = new boolean[n];
        for(int[] edge:edges){
            championExist[edge[1]] = true;
        }
        int count = 0;
        int falseindex = 0;
        for(int i = 0; i < championExist.length; i++){
            if(!championExist[i]){
                count++;
                falseindex = i;
            }
        }
        if(count>1){
            return -1;
        }
        return falseindex;
    }
}