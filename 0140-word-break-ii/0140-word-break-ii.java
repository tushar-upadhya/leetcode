class Solution {
   public List<String> wordBreak(String s, List<String> wordDict) {  
       HashMap<Integer, List<String>> map = new HashMap<>(); 
       HashSet<String> set = new HashSet<>(wordDict);
      
       return helper(s, 0, set, map);
}

private List<String> helper(String str, int start, HashSet<String> dict, HashMap<Integer, List<String>> map ) {

    if (map.containsKey(start))
        return map.get(start); 

    List<String> validSubString = new ArrayList<>();

    if (start == str.length())
        validSubString.add("");

    for (int end = start + 1; end <= str.length(); end++) {
        String prefix = str.substring(start, end);
        
        if (dict.contains(prefix)) {
            List<String> suffixes = helper(str, end, dict, map);
            for (String suffix : suffixes)
               validSubString.add(prefix + (suffix.equals("") ? "" : " ") + suffix); 
        }
    }
 
    map.put(start, validSubString);
    return validSubString;
 }
}