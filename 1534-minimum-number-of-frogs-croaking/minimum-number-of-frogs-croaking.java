class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int activeFrogs = 0;
        int result = -1;
        for(char ch: croakOfFrogs.toCharArray()){
            switch(ch){
                case 'c':
                    c++;
                    activeFrogs++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a': 
                    a++;
                    break;
                case 'k': 
                    k++;
                    activeFrogs--;
                    break;
            }
            result = Math.max(result,activeFrogs);
            if(c<r || r<o || o < a || a < k)
                return -1;
            
        }
        return activeFrogs == 0 ? result : -1;
    }
}