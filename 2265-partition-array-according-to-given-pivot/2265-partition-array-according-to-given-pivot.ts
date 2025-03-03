function pivotArray(nums: number[], pivot: number): number[] {
    let less: number[] = [];
    let equal: number[] = [];
    let greater: number[] = [];

    for(let num of nums){
        if(num < pivot) less.push(num);
        else if(num === pivot) equal.push(num);
        else greater.push(num);
    }
    return [...less, ...equal, ...greater]
};