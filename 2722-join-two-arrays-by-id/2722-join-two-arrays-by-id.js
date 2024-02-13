/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const combineArr = arr1.concat(arr2)
    const merged = {}
    
    combineArr.forEach((obj) => {
        const id = obj.id
        
        if(!merged[id]){
            merged[id] = {...obj}
        }else{
            merged[id] = {...merged[id], ...obj}
        }
    })
    
    const joinedArr = Object.values(merged)
    joinedArr.sort((a, b) => a.id - b.id)
    
    return joinedArr;
};