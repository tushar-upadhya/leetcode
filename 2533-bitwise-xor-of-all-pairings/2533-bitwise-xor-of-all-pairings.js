/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var xorAllNums = function(nums1, nums2) {
    let count1 = nums1.length;
    let count2 = nums2.length;
    let x1 = 0; 
    let x2 = 0;

    if(count1 % 2 !== 0){
        for(let num of nums2){
            x2 ^= num;
        }
    }
    if(count2 % 2 !== 0){
        for(let num of nums1){
            x1 ^= num;
        }
    }
    return x1 ^ x2;
};