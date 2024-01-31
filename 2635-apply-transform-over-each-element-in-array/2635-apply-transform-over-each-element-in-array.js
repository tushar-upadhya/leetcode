/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let arrLength = arr.length
    
    for(let index = 0; index < arrLength; index++){
        arr[index] = fn(arr[index], index)
    }
    return arr
};