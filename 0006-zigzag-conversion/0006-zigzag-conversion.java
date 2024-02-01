class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        Map<Integer, String> a = new HashMap<>();
        
        for(int i = 0; i < numRows; i++){
            a.put(i, "");
        }
        
        int row = 0;
        boolean isVisit = true;
        for(char c : s.toCharArray()) {
            
            a.put(row, a.get(row) + c);
            if(isVisit)
                row++;
            else
                row--;
            if(row == numRows - 1){
                isVisit = false;
            } else if(row == 0){
                isVisit = true;
            }
        }
        
        String result = "";
        
        for(String str : a.values()){
            result += str;
        }
        
        return result;
    }
}