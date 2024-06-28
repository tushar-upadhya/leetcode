class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long result = 0;
        long x = 1;
        long degree[] = new long[n];

        for(int road[] : roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);

        for(long  i : degree) result += i * (x++);

        return result;
    }
}