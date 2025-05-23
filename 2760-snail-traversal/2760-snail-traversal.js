/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    if(this.length !== rowsCount * colsCount) return []

    let result = Array(rowsCount).fill([]).map(() => [])

    for(let j = 0; j < this.length; j++){
        const i = Math.floor(j / rowsCount);

        if(i % 2 === 0){
            result[j % rowsCount][i] = this[j];
        }else{
            result[rowsCount - j % rowsCount - 1][i] = this[j];
        }
    }
    return result;
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */