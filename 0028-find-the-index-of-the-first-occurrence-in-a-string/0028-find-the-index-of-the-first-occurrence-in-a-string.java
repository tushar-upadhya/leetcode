class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == needle.length()){
            return haystack.equals(needle) ? 0 : -1;
        }
        int start = 0;
        int end = needle.length();

        while(end <= haystack.length()){
            boolean found = true;

            if(haystack.substring(start, end).equals(needle)){
                return start;
            }
            start++;
            end++;
        }
        return -1;
    }
}