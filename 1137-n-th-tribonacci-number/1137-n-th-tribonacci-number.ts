function tribonacci(n: number): number {
    const arr = [0, 1, 1]
    
    if(n < 3){
        return arr[n];
    }
    
    for(let i = 3; i <= n; i++){
        let current = arr[0] + arr[1] + arr[2];
        
        arr[0] = arr[1];
        arr[1] = arr[2];
        arr[2] = current;
    }
    return arr[2];
};