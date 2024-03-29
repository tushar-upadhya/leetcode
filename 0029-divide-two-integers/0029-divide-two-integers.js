/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
    if(divisor === 0) return 0;
    if(dividend === 0) return 0;
    if (dividend === -2147483648 && divisor === -1) return 2147483647;
    
    let isPostive = true;
    if(dividend > 0 != divisor > 0) isPostive = false;
    
    divisor = Math.abs(divisor)
    dividend = Math.abs(dividend)
    
    let count = 1;
    let result = 0;
    let base = divisor;
    
    while(dividend >= divisor){
        count = 1;
        base = divisor;
        
        while(base <= (dividend >> 1)){
            base = base << 1;
            count = count << 1;
        }
        result += count;
        dividend -= base
    }
    if(!isPostive) result = -result;
    return result;
};