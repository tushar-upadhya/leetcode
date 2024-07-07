/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var numWaterBottles = function (numBottles, numExchange) {
    let totalBottles = numBottles;

    while (numBottles >= numExchange) {
        totalBottles += Math.floor(numBottles / numExchange);
        numBottles = Math.floor(numBottles / numExchange) + (numBottles % numExchange);
    }

    return totalBottles;
};