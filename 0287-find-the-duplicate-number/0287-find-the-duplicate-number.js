/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    let slow = nums[0];
    
    for(let i = 0; i < nums.length; i++){
        let index = Math.abs(nums[i]);
        if(nums[index] < 0){
            return index;
        }
        nums[index] = -nums[index];
    }
    return -1;
};