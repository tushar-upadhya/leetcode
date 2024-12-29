/**
 * @param {string[]} words
 * @param {string} target
 * @return {number}
 */
var numWays = function(words, target) {
    const MOD = 1_000_000_007;
    const m = target.length;
    const n = words[0].length;

    const count = Array.from({length : n}, () => Array(26).fill(0));
    
    for(const word of words){
        for(let i = 0; i < n; i++){
            count[i][word.charCodeAt(i) - 97]++;
        }
    }

    const dp = Array(m + 1).fill(0);
    dp[0] = 1;

    for(let i = 0; i < n; i++){
        for(let j = m - 1; j >= 0; j--){
            const charIndex = target.charCodeAt(j) - 97;
            dp[j + 1] = (dp[j + 1] + dp[j] * count[i][charIndex]) % MOD;
        }
    }
    return dp[m];
};