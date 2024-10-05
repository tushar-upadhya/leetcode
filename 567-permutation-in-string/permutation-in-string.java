
class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int str = s1.length();
    int str2 = s2.length();
    if (str > str2) return false;
    
    int[] count = new int[26];
    for (int i = 0; i < str; i++)
        count[s1.charAt(i) - 'a']++;
    
    for (int i = 0; i < str2; i++) {
           count[s2.charAt(i) - 'a']--;
        if(i - str >= 0)
          count[s2.charAt(i - str) - 'a']++;
        if (helper(count)) return true;
    }
    
    return false;
}

  private boolean helper(int[] count) {
    for (int i = 0; i < 26; i++) {
        if (count[i] != 0) return false;
    }
    return true;
    }
}
