function heightChecker(heights: number[]): number {
    let notMatchCounter: number = 0;
    const sortedHeights: number[] = [...heights].sort((a, b) => a - b);

    for(let i = 0; i < heights.length; i++){
        if(heights[i] !== sortedHeights[i]) ++notMatchCounter;
    }
    return notMatchCounter;
};