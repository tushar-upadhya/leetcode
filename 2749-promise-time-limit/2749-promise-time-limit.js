/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    return async function(...args) {
        return new Promise((delay, reject) =>{
            const timeOut = setTimeout(() =>{
                clearTimeout(timeOut)
                reject("Time Limit Exceeded")
            }, t);

            fn(...args)
            .then((result) =>{
                clearTimeout(timeOut);
                delay(result);
            })
            .catch((error) =>{
                clearTimeout(timeOut);
                reject(error);
            })
        })
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */