/**
 * @param {string} s
 * @return {boolean}
 */
var isNumber = function(s) {
    s = s.trim();

    const validNumber = /^[\+\-]?((\d+\.\d*)|(\.\d+)|(\d+))([eE][\+\-]?\d+)?$/;

    return validNumber.test(s);
};