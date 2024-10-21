class Solution {
    public int maxUniqueSplit(String str) {
        Set<String> set = new HashSet<>();
        return helper(str, 0, set);
    }

    private int helper(String str, int start, Set<String> set){
        if(start == str.length()){
            return set.size();
        }
        
        int maxi = 0;

        for(int i = start + 1; i <= str.length(); i++){
            String sb = str.substring(start, i);

            if(!set.contains(sb)){
                set.add(sb);
                maxi = Math.max(maxi, helper(str, i, set));
                set.remove(sb);
            }
        }
        return maxi;
    }
}