/**
 * @param {number[]} nums
 * @return {number}
 */
var minIncrementForUnique = function(nums) {
    nums.sort((a, b) => a - b);

    let numTracker = 0;
    let minIncrement = 0;

    for(let num of nums){
        numTracker = Math.max(numTracker, num);
        minIncrement += numTracker - num;
        numTracker++;
    }  
    return minIncrement;
};