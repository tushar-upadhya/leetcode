/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
  
    const result = Math.abs(x).toString().split('').reverse().join('');
  
    if (result > 2**31) return 0;
  
    return result * Math.sign(x);
};