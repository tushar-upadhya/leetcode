function numSubarrayProductLessThanK(nums: number[], k: number): number {
    if(k <= 1){
        return 0;
    }
    
    let product = 1;
    let i = -1;
    let j = 0;
    let result = 0;
    
    while(i < nums.length){
        while(product < k){
            i++;
            result += i - j;
            product *= nums[i]
        }
        while(product >= k){
            product /= nums[j];
            j++;
        }
    }
    return result;
};