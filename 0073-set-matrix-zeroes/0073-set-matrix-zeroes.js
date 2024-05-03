/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    var matrix = matrix
    var dimension = matrix.length;
    var row = [];
    var column = [];
    
    for(let i = 0; i < dimension; i++){
        for( let j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] == 0){
                row.push(i);
                column.push(j);
            }
        }
    }
    
    for(let i = 0; i < row.length; i++){
        var changeRowLength = matrix[row[i]].length;
        var index = row[i]
        matrix[index] = []
        for(let j = 0; j < changeRowLength ; j++){
            matrix[index].push(0)
        }
    }
    
    for(let i = 0; i< dimension; i++){
        for(let j = 0; j < column.length; j++){
            var columnIndex = column[j]
            matrix[i][columnIndex] = 0;
        }
    }
    
    return (matrix);
};