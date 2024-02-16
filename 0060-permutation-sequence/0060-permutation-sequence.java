class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < n ; i++){
            fact *= i;
            list.add(i);
        }
        list.add(n);
        k = k - 1;
        
        StringBuilder sb = new StringBuilder();
        
        while(true){
            int index = k / fact;
            
            sb.append(String.valueOf(list.get(index)));
            list.remove(index);
            
            if(list.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / list.size();
        }
        return sb.toString();
    }
}