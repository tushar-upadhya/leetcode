class Solution {
    public int[] constructDistancedSequence(int n) {
        int result[] = new int[2 * n - 1];
        Arrays.fill(result, -1);
        boolean used[] = new boolean[n + 1];

        helper(0, n, result, used);

        return result;
    }

    private boolean helper(int i, int n, int result[], boolean used[]){
        if(i >= result.length){
            return true;
        }

        if(result[i] != -1){
            return helper(i + 1, n, result, used);
        }

        for(int num = n; num >= 1; num--){
            if(used[num]){
                continue;
            }
            used[num] = true;
            result[i] = num;

            if(num == 1){
                if(helper(i + 1, n, result, used)){
                    return true;
                }
            }else{
                int j = result[i] + i;
                if(j < result.length && result[j] == -1){
                    result[j] = num;

                    if(helper(i + 1, n, result, used)){
                        return true;
                    }
                    result[j] = -1;
                }
            }
            used[num] = false;
            result[i] = -1;
        }
        return false;
    }
}