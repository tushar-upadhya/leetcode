function isPalindrome(x: number): boolean {
    if(x < 0) return false
    
    let reversed = 0
    let n = x
    
    while(n > 0){
        const digit = n % 10
        reversed = reversed * 10 + digit
        
        n = Math.floor(n / 10)
    }
    return reversed === x
};