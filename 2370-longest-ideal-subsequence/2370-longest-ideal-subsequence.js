/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var longestIdealString = function(s, k) {
    
const dp = Array(26).fill(0)
  for (let char of s) {
    const i = char.charCodeAt(0) - 97
    let minIndex = Math.max(i - k, 0),
      maxIndex = Math.min(i + k, 25)
    for (let j = minIndex; j <= maxIndex; j++) {
      dp[i] = Math.max(dp[j], dp[i])
    }
    dp[i]++
  }
  return dp.reduce((maxCount, count) => Math.max(maxCount, count), 0)
}