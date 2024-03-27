function numDistinct(s: string, t: string): number {
    const n = s.length;
    const m = t.length;
    let result = new Array(m + 1);
    result[0] = 1
    
    for(let i = 1; i < m + 1; i++){
        result[i] = 0;
    }
    
    for(let i = 1; i <= n; i++){
        for(let j = m; j >= 1; j--){
            if(s[i - 1] == t[j - 1]){
                result[j] = (result[j - 1] + result[j])
            }
        }
    }
    return result[m];
};