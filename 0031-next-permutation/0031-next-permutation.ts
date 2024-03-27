/**
 Do not return anything, modify nums in-place instead.
 */
function nextPermutation(nums: number[]): void {
    
    function reverse(nums:number[], startIndex:number, endIndex:number){
        while(startIndex < endIndex){
            let temp = nums[startIndex]
            nums[startIndex] = nums[endIndex]
            nums[endIndex] = temp
            startIndex++;
            endIndex--;
        }
        
    }

    const length = nums.length
    let index = -1
    
    for(let i = length - 2; i >= 0; i--){
        if(nums[i] < nums[i + 1]){
            index = i
            break
        }
    }

    if(index == -1){
       return reverse(nums, 0, length - 1)
    }

    for(let i = length - 1; i > index; i--){
        if(nums[i] > nums[index]){
            let temp = nums[index]
            nums[index] = nums[i]
            nums[i] = temp
            break
        }
    }
    reverse(nums,index + 1, length - 1)
    return
};