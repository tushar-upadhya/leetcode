/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number}
 */
var minPatches = function(nums, n) {
    let count = 0;
    let missing = 1;
    let i = 0;
    
    while (missing <= n) {
        if (i < nums.length && nums[i] <= missing) {
            missing += nums[i++];
        } else {
            missing += missing;
            count++;
        }
    }
    return count;
};