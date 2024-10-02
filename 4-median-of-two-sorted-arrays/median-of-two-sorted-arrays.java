class Solution{
    public double findMedianSortedArrays(int[]nums1,int[]nums2){
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int m1 = 0;
        int m2 = 0;

        for(int count = 0; count <= (n + m) / 2; count++){
            m2 = m1;
            if(i != n && j != m){
                if(nums1[i] > nums2[j]){
                    m1 = nums2[j++];
                }else{
                    m1 = nums1[i++];
                }
            }else if(i < n){
                m1 = nums1[i++];
            }else{
                m1 = nums2[j++];
            }
        }
        if((n + m) % 2 == 1){
            return(double)m1;
        }else{
            double result = (double) m1 + (double)m2;
            return result/2.0;
        }
    }
} 