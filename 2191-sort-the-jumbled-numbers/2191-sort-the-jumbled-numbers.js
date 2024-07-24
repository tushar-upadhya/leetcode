/**
 * @param {number[]} mapping
 * @param {number[]} nums
 * @return {number[]}
 */
var sortJumbled = function(mapping, nums) {
    const translate = (n) => +(n.toString().split('').map((v) => mapping[v]).join(''));
    const map = {};

    for(let num of nums){
        map[num] = translate(num);
    }
    return nums.sort((a, b) => map[a] - map[b]);
};