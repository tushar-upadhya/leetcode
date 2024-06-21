/**
 * @param {number[]} customers
 * @param {number[]} grumpy
 * @param {number} minutes
 * @return {number}
 */
var maxSatisfied = function(customers, grumpy, minutes) {
    let totalCustomers = 0;
    let maxCustomers = 0;
    let windowSum = 0;
    const n = customers.length;

    for(let i = 0; i < n; i++){
        if(grumpy[i] === 0){
            totalCustomers += customers[i];
        }
    }

    for(let i = 0; i < minutes; i++){
        windowSum += customers[i] * grumpy[i];
    }
    maxCustomers = windowSum;

    for(let i = minutes; i < n; i++){
        windowSum += customers[i] * grumpy[i] - customers[i - minutes] * grumpy[i - minutes];
        maxCustomers = Math.max(maxCustomers, windowSum);
    }

    return totalCustomers + maxCustomers;
};