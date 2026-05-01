class Solution {
    HashMap<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return helper(s1, s2);
    }

    boolean helper(String s1, String s2) {
        if (s1.equals(s2)) return true;

        String key = s1 + "#" + s2;
        if (map.containsKey(key)) return map.get(key);

        int length = s1.length();
        int count[] = new int[26];
 
        for (int i = 0; i < length; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                map.put(key, false);
                return false;
            }
        }

        for (int k = 1; k < length; k++) {
            if (helper(s1.substring(0, k), s2.substring(0, k)) &&
                helper(s1.substring(k), s2.substring(k))) {
                map.put(key, true);
                return true;
            }

            if (helper(s1.substring(0, k), s2.substring(length - k)) &&
                helper(s1.substring(k), s2.substring(0, length - k))) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}