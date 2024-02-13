function firstPalindrome(words: string[]): string {
  for(const str of words){
      let left = 0;
      let right = str.length - 1;
      let flag = false;
      
      for(let i = 0; i < str.length / 2; i++){
          if(str[left] !== str[right]){
              flag = true;
              break;
          }
          left++;
          right--;
      }
      if(!flag) return str;
  }
    return ""
};