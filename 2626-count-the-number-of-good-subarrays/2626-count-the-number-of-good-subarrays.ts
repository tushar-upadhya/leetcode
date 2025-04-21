function countGood(nums: number[], k: number): number {
    const freq: Map<number, number> = new Map();
    let left = 0;
    let pairCount = 0;
    let result = 0;

    for(let right = 0; right < nums.length; right++){
        const count = freq.get(nums[right]) ?? 0;
        pairCount += count;
        freq.set(nums[right], count + 1);

        while(pairCount >= k){
            result += nums.length - right;
            const leftCount = freq.get(nums[left])!;
            freq.set(nums[left], leftCount - 1);
            pairCount -= leftCount - 1;
            left++;
        }
    }
    return result;
};