class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i < 100;i++){
            if(i <= high && (i % 10 == i / 10)){
                count++;
            }
        }
        for(int i = 1000; i < 10000; i++){
                int left = 0;
                int right = 0;
                if(i <= high && i >= low) {
                    //1st
                    left += i / 1000;
                    //2nd
                   int sec = i / 100;
                   left += sec % 10;
                    //3rd
                    int third = i / 10;
                    third %= 10;
                    right += third;
                    //4th
                    right += (i % 10);
                if(left == right){
                    System.out.print(i +" ");count++;
                    }
            }
        }
        
        return count;
    }
}