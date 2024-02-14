/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if(typeof obj !== 'object' || obj === null){
        return obj
    }
    
    if(Array.isArray(obj)){
        const compactArr = []
        
        for(let i = 0; i < obj.length; i++){
            let value = compactObject(obj[i])
            
            if(value){
                compactArr.push(value)
            }
        }
        return compactArr
    }
    
    const compactObj = {}
    
    for(let key in obj){
        const value = compactObject(obj[key])
        
        if(value){
            compactObj[key] = value
        }
    }
    return compactObj
};