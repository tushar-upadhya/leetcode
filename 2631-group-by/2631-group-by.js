/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
     const group = {};
    for (const val of this) {
        const key = fn(val);
        group.hasOwnProperty(key) ? group[key].push(val) : group[key] = [val];
    }

    return group;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */