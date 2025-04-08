/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function(nums) {
    let visited = new Array(128).fill(false);

    for(let i = nums.length - 1; i >= 0; i--){
        if(visited[nums[i]]){
            return Math.floor(i / 3) + 1;
        }
        visited[nums[i]] = true;
    }
    return 0;
};