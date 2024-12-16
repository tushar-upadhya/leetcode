import java.util.StringTokenizer;

class Solution {
    public int compareVersion(String version1, String version2) {
        List<String> v1 = helper(version1);   
        List<String> v2 = helper(version2);
        int m = v1.size(); 
        int n = v2.size();
        int i = 0;

        while(i < m || i < n){
            int a = i < m ? Integer.parseInt(v1.get(i)) : 0;
            int b = i < n ? Integer.parseInt(v2.get(i)) : 0;

            if(a > b) return 1;
            else if(b > a) return -1;
            else i++;
        } 
        return 0;
    }

    private List<String> helper(String version){
        StringTokenizer tokenizer = new StringTokenizer(version, ".");
        List<String> versionToken =  new ArrayList<>();

        while(tokenizer.hasMoreTokens()){
            versionToken.add(tokenizer.nextToken());
        }
        return versionToken;
    }
}