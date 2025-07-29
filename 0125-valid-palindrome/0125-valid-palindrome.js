/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let left = 0;
    let right = s.length - 1;

    while(left < right){
        while(left < right && !helper(s[left])) left++;
        while(left < right && !helper(s[right])) right--;

        if(s[left].toLowerCase() !== s[right].toLowerCase())
            return false;

            left++;
            right--;
    
    }
        return true;
};

function helper(c) {
    return /^[a-z0-9]$/i.test(c);
}