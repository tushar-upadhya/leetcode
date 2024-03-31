/**
 * @param {number[]} nums
 * @param {number} minK
 * @param {number} maxK
 * @return {number}
 */
var countSubarrays = function(nums, minK, maxK) {
    const n = nums.length;
    let result = 0;
    let minIndex = -1;
    let maxIndex = -1;
    let currentIndex = -1;
    
    for(let i = 0; i < n; i++){
        if(nums[i] < minK || nums[i] > maxK){
            currentIndex = i;
        }
        
        if(nums[i] === minK) minIndex = i;
        
        if(nums[i] === maxK) maxIndex = i;
        
        const smaller = Math.min(minIndex, maxIndex)
        const temp = smaller - currentIndex
        
        result += temp <= 0 ? 0 : temp
    }
    return result
};