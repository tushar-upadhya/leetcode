function countGoodIntegers(n: number, k: number): number {
    const seen = new Set<string>();
    let count = 0;

    const palindromes = generatePalindromes(n);

    for(const p of palindromes){
        if(BigInt(p) % BigInt(k) !== 0n) continue;

        const sortedDigits = p.split('').sort().join('');
        if(seen.has(sortedDigits)) continue;

        seen.add(sortedDigits);
        count += countValidPermutations(sortedDigits);
    }
    return count;
};

function generatePalindromes(n : number): string[]{
    const result : string[] = [];
    const half = Math.floor((n + 1) / 2);
    const start = Math.pow(10, half - 1);
    const end = Math.pow(10, half);

    for(let i = start; i < end; ++i){
        const left = i.toString();
        let right = left;

        if(n % 2 === 1) right = right.slice(0, -1);
        right = right.split('').reverse().join('');
        result.push(left + right);
    }
    return result;
}

function countValidPermutations(digits: string): number{
    const freq: Record<string, number> = {};
    for(const c of digits){
        freq[c] = (freq[c] || 0) + 1;
    }
    let total = factorial(digits.length);
    for(const f of Object.values(freq)){
        total /= factorial(f);
    }

    if(freq['0']){
        freq['0']--;

        let sub = factorial(digits.length - 1);
        for(const f of Object.values(freq)){
            sub /= factorial(f);
        }
        total -= sub;
        freq['0']++;
    }
    return total;
}

const factCache: number[] = Array(21).fill(-1);

function factorial(x : number):  number{
    if(x === 0 || x === 1) return 1;
    if(factCache[x] !== -1) return factCache[x];
    
    return factCache[x] = x * factorial(x - 1);
}
