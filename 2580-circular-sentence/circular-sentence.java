class Solution {
    public boolean isCircularSentence(String sentence) {
        String str[] = sentence.split("\\s+");

        for(int i = 0; i < str.length - 1; i++){
            if(str[i].charAt(str[i].length() - 1) == str[i + 1].charAt(0)){
                continue;
            }
            else{
                return false;
            }
        }
        return str[0].charAt(0) == str[str.length - 1].charAt(str[str.length - 1].length() - 1) ? true : false;
    }
}