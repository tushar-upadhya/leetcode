class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        String res[] = new String[score.length];
        int s[] = new int[score.length];
        
        for(int i = 0; i < s.length; i++){
            s[i] = score[i];
        }
        
        Arrays.sort(score);
        int j = 1;
        
        for(int i = score.length - 1; i >= 0; i--){
            map.put(score[i], j);
            j++;
        }
        
        for(int i = 0; i < s.length; i++){
            if(map.get(s[i]) == 1) res[i] = "Gold Medal";
            else if(map.get(s[i]) == 2) res[i] = "Silver Medal";
            else if(map.get(s[i]) == 3) res[i] = "Bronze Medal";
            else res[i] = String.valueOf(map.get(s[i]));
        }
        return res;
    }
}