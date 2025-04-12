class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int maxi = 0;
        int right = height.length - 1;

        while(left < right){
            if(height[left] < height[right]){
                maxi = Math.max(maxi, height[left] * (right - left));
                left++;
            }else{
                maxi = Math.max(maxi, height[right] * (right - left));
                right--;
            }
        }
        return maxi;
    }
}