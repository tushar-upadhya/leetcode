/**
 * @param {string[]} strs
 * @return {string}
 */
 
var longestCommonPrefix = function(strs) {
    let str = strs[0];
    let length = str.length;

    for (let i = 1; i < strs.length; i++) {
        let s = strs[i];

        while (str !== s.substring(0, length)) {
            length--;
            
            if (length === 0) {
                return "";
            }
            str = str.substring(0, length);
        }
    }
    return str;    
};