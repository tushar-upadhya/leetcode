/**
 * @param {number[]} quality
 * @param {number[]} wage
 * @param {number} k
 * @return {number}
 */
class Workers {
    constructor(ratio, quality) {
        this.ratio = ratio;
        this.quality = quality;
    }
}

var mincostToHireWorkers = function (quality, wage, k) {
    const n = quality.length;
    let minCost = Number.MAX_VALUE;
    let qualityTillNow = 0;
    let workers = [];

    for (let i = 0; i < n; i++) {
        workers.push(new Workers(wage[i] / quality[i], quality[i]));
    }
    workers.sort((a, b) => a.ratio - b.ratio);

    let highQualityWorkers = [];

    for (let worker of workers) {
        let ratio = worker.ratio;
        let qua = worker.quality;

        qualityTillNow += qua;
        highQualityWorkers.push(-qua);
        highQualityWorkers.sort((a, b) => a - b);

        if (highQualityWorkers.length > k) {
            qualityTillNow += highQualityWorkers.shift();
        }

        if (highQualityWorkers.length === k) {
            minCost = Math.min(minCost, qualityTillNow * ratio);
        }
    }
    return minCost;
};
