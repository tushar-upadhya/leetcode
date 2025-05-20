class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<List<Integer>> states = new ArrayList<>();
        generateStates(m, new ArrayList<>(), states);

        int size = states.size();
        List<List<Integer>> transtitions = new ArrayList<>();

        for(int i = 0; i < size; i++){
            transtitions.add(new ArrayList<>());

            for(int j = 0; j < size; j++){
                if(helper(states.get(i), states.get(j))){
                    transtitions.get(i).add(j);
                }
            }
        }

        long dp[] = new long[size];
        Arrays.fill(dp, 1);

        for(int col = 1; col < n; col++){
            long newDp[] = new long[size];

            for(int i = 0; i < size; i++){
                for(int j : transtitions.get(i)){
                    newDp[j] = (newDp[j] + dp[i]) % MOD;
                }
            }
            dp = newDp;
        }
        long result = 0;
        for(long val : dp){
            result = (result + val) % MOD;
        }
        return (int) result;
    }

    private void generateStates(int m, List<Integer> current, List<List<Integer>> states){
        if(current.size() == m){
            states.add(new ArrayList<>(current));
            return;
        }

        for(int color = 1; color <= 3; color++){
            if(current.isEmpty() || current.get(current.size() - 1) != color){
                current.add(color);
                generateStates(m, current, states);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean helper(List<Integer> a, List<Integer> b){
        for(int i = 0; i < a.size(); i++){
            if(a.get(i).equals(b.get(i))) return false;
        }
        return true;
    }
}