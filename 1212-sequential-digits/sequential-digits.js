/**
 * @param {number} low
 * @param {number} high
 * @return {number[]}
 */
var sequentialDigits = function(low, high) {
    const arr = []

    for(let i = 1; i <= 9; ++i){
        let num = i;
        let nextDigit = i + 1;

        while(num <= high && nextDigit <= 9){
            num = num * 10 + nextDigit;

            if(low <= num && num <= high){
                arr.push(num);
            }
            ++nextDigit;
        }
    }
    arr.sort((a, b) => a - b);
    return arr;
};