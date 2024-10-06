class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int i = 0;
        int j = 0;
        
        while (i < s1.length && j < s2.length){
            if (!s1[i].equals(s2[j])) break;
            i++;
            j++;
        }
        
        if (i == s1.length || j == s2.length) return true;
        
        int length1 = s1.length - 1;
        int length2 = s2.length - 1;
        
        while(length1 >= i && length2 >= j){
            if(!s1[length1].equals(s2[length2])) return false;
            length1--;
            length2--;
        }
        return length1 < i || length2 < j;
    }
}