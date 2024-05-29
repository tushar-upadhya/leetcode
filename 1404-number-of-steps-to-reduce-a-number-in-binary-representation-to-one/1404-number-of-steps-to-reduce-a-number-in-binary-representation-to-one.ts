function numSteps(s: string): number {
    let count = 0;
    const str = s.length;
    let i = str - 1;
    let remaninder = 0;
    
    while(i >= 0){
        if(s[i] === '0'){
            if(remaninder === 0){
                count += 1;
            }else{
                count += 2;
            }
        }else{
            if(remaninder ===  0){
                if(i === 0){
                    return count;
                }
                count += 2;
                remaninder = 1;
            }else{
                count += 1;
            }
        }
        i -= 1;
    }
    return count;
};