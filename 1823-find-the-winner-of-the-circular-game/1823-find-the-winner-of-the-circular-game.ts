function findTheWinner(n: number, k: number): number {
    let index = 0;

    for(let i = 1; i <= n; i++){
        index = (index + k) % i;
    }  
    return index + 1;
};