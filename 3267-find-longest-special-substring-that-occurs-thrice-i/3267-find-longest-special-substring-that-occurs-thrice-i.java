class Solution {
    public int maximumLength(String s) {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            int index = i;

            while(index < s.length() && s.charAt(index) == s.charAt(i)){
                list.add(s.substring(i, index + 1));
                index++;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for(String sub : list){
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        int maxi = 0;

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String substring = entry.getKey();
            int count = entry.getValue();

            if(count >= 3){
                maxi = Math.max(maxi, substring.length());
            }
        }
        return maxi == 0 ? - 1 : maxi;
    }
}