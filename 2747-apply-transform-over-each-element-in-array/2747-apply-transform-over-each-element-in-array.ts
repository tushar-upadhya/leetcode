function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    const transform : number[] = []

    for(let i = 0; i < arr.length; i++){
        transform[i] = fn(arr[i], i);
    }  
    return transform;
};