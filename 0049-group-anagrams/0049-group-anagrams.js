/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let result = {};

    for(let s of strs){
        let key = s.split('').sort().join('');

        if(!result[key]){
            result[key] = [];
        }
        result[key].push(s);
    }
    return Object.values(result);
};