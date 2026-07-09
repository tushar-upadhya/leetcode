/**
 * @param {number} n
 * @param {number[]} nums
 * @param {number} maxDiff
 * @param {number[][]} queries
 * @return {boolean[]}
 */
var pathExistenceQueries = function(n, nums, maxDiff, queries) {
    const count = new Array(n).fill(0);
    let id = 0;

    for(let i = 0; i < n; i++){
        if(nums[i] - nums[i - 1] > maxDiff) id++;
        count[i] = id;
    }
    const result = new Array(queries.length);

    for(let i = 0; i < queries.length; i++){
        const [u, v] = queries[i];
        result[i] = count[u] === count[v];
    }
    return result;
};