class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0;
        double right = 1;
        int result[] = new int[2];
        
        while(left <= right){
            double mid = left + (right - left) / 2;
            int j = 1;
            int total = 0;
            int num = 0;
            int den = 0;
            double maxi = 0;
            
            for(int i = 0; i < n; i++){
                while(j < n && arr[i] > arr[j] * mid){
                    ++j;
                }
                total += n - j;
                
                if(j < n && maxi < arr[i] * 1.0 / arr[j]){
                    maxi = arr[i] * 1.0 / arr[j];
                    num = i;
                    den = j;
                }
            }
            if(total == k){
                result[0] = arr[num];
                result[1] = arr[den];
                break;
            }
            if(total > k){
                right = mid;
            }else{
                left = mid;
            }
        } 
        return result;
    }
}