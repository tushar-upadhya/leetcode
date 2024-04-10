function deckRevealedIncreasing(deck: number[]): number[] {
    let result = []
    const order = deck.sort((a, b) => a - b)
    
    while(order.length){
        if(result.length){
            result.unshift(result.pop())
        }
        result.unshift(order.pop())
    }
    return result;
};