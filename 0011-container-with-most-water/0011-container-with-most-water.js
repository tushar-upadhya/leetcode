/**
 * @param {number[]} height
 * @return {number}
 */
const maxArea = function(height) {
    let result = 0;
    let right = height.length - 1;
    let left = 0;
    
    while(left < right){
        let small = Math.min(height[left], height[right]);
        let area = (right - left) * small;
        
        if(area > result) result = area;
        
        if(height[left] < height[right]) left++;
        else
            right--;
    }
    return result;
};