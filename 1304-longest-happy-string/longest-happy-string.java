class Solution {
    public String longestDiverseString(int a, int b, int c) {
    int ca = 0;
    int cb = 0;
    int cc = 0;
    int maxLength = a + b + c;
    int i = 0;
    StringBuilder sb = new StringBuilder(); 
    while(i<(maxLength)){
      if(ca != 2 && a >= b && a >= c || a > 0 && (cb == 2 || cc == 2)){
        sb.append('a');
        ca++; 
        cb = 0;
        cc = 0;
        a--;
      }else if(cb != 2 && b >= a && b >= c || b > 0 && (ca == 2 || cc == 2)){
        sb.append('b');
        cb++; 
        ca = 0;
        cc = 0;
        b--;
      }else if(cc != 2 && c >= a && c >= b ||  c > 0 && (ca == 2 || cb == 2)){
        sb.append('c');
        cc++; 
        ca=0;
        cb=0;
        c--;
      }
     i++;
    }
    return sb.toString();
    }
}