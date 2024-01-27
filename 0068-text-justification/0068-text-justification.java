class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(String str : words){
            int len = str.length();
            if(sb.length() == 0){
                sb.append(str);
            }else if(sb.length() + 1 + len <= maxWidth){
                sb.append(" ");
                sb.append(str);
            }else{
                if(sb.length() != maxWidth){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i = 1; i < sb.length(); i++){
                        if(sb.charAt(i) == ' ') list.add(i);
                    }
                    
                    int length = list.size();
                    if(length == 0){
                        while(sb.length() < maxWidth) sb.append(" ");
                    }else{
                        int x = (maxWidth - sb.length()) / length;
                        int y = (maxWidth - sb.length()) % length - length;
                        for(int i = length -1; i >= 0; i--){
                            for(int j = 0; j < x; j++){
                                sb.insert(list.get(i)," ");
                            }
                            y++;
                            if(y > 0) sb.insert(list.get(i)," ");
                        }
                    }
                    
                }
                result.add(sb.toString());
                sb = new StringBuilder(str);
            }
        }
        while(sb.length() < maxWidth) sb.append(" ");
        result.add(sb.toString());
        return result;
    }
}