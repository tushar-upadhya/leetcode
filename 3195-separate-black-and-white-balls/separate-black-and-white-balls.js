/**
 * @param {string} s
 * @return {number}
 */
var minimumSteps = function(s) {
    let zeroPosition=-1;//took -1 because initially we dont know that if there is aa zero in a string or not 
    let swapCount=0;
    for(let i=0;i<s.length;i++) {//traverse the complete string ans check for zerfo
        
        if(s[i]==0) {//if zero ocuurs then count how many swaps it toke to     be place on the position that is reserver for it 
       
        zeroPosition++;//increment the zeroPosition to track the position of the zero in wich it has to place
        
        swapCount+=(i-zeroPosition);//we can not directly place zero in its actual posiion in just one swap we hae to swap only adjacent element that would taae the difference between current zero position and ccorrect zero position so we place the difference in our final result
       } 
    }
    return swapCount;
};