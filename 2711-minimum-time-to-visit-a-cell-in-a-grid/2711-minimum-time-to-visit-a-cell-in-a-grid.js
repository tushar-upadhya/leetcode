/**
 * @param {number[][]} grid
 * @return {number}
 */
var minimumTime = function(grid) {
    
    if(grid[0][1]>1 && grid[1][0]>1){
        return -1;
    }
    //START Heap class in javascript
    class Heap{
        constructor(type){
            this.type = type;
            this.data = [];
            this.data[0] = undefined;
        }
        print(){
            for(let i=1;i<this.data.length;i++){
                console.log(this.data[i])
            }
        }
        getSize(){
            return this.data.length-1;
        }
        insert(value){
            this.data.push(value);
            if(this.data.length==2){
                return ;
            }
            let lastIndex = this.data.length-1;
            while(this.data[Math.floor(lastIndex/2)]!==undefined && this.compare(this.data[lastIndex],this.data[Math.floor(lastIndex/2)])>0){
                let temp = this.data[Math.floor(lastIndex/2)];
                this.data[Math.floor(lastIndex/2)] = this.data[lastIndex];
                this.data[lastIndex] = temp;
                lastIndex = Math.floor(lastIndex/2);
            }
        }
        //This returns a positive number if a is greater than b. Here meaing of being greater depends on the type of heap. For max heap it will return positive number if a>b and for min heap it will return positive number if a<b . 
        compare(a,b){
            if(this.type==="min"){
                if(Array.isArray(a) && Array.isArray(b)){
                    return b[0]-a[0];
                }else{
                    return b-a;
                }
            }else{
                if(Array.isArray(a) && Array.isArray(b)){
                    return a[0]-b[0];
                }else{
                    return a-b;
                }
            }
        }
        removeTop(){
            let max = this.data[1];
            if(this.getSize()>1){
                this.data[1] = this.data.pop();
                this.heapify(1);
            }else{//If the size is 0 then just remove the element, no shifting and hipify will be applicable
                this.data.pop();
            }
            return max;
        }
        getTop(){
            let max = null;
            if(this.getSize()>=1){
                max = this.data[1];
            }
            return max;
        }
        heapify(pos){
            if(pos*2>this.data.length-1){
                //That means element at index 'pos' is not having any child
                return;
            }
            if(
                (this.data[pos*2]!==undefined && this.compare(this.data[pos*2],this.data[pos])>0)
              || (this.data[pos*2+1]!==undefined && this.compare(this.data[pos*2+1],this.data[pos])>0)
              ){
                if(this.data[pos*2+1]===undefined || this.compare(this.data[pos*2+1],this.data[pos*2])<=0){
                    let temp = this.data[pos*2];
                    this.data[pos*2] = this.data[pos];
                    this.data[pos] = temp;
                    this.heapify(pos*2);
                }else{
                    let temp = this.data[pos*2+1];
                    this.data[pos*2+1] = this.data[pos];
                    this.data[pos] = temp;
                    this.heapify(pos*2+1);
                }
            }
        }
    }
    //END Heap class in javascript
    
    let ans = check(0);
    return ans;
    
    
    function check(cap){
        let minHeap = new Heap('min');
        let queue=[],dx=[[0,1],[0,-1],[1,0],[-1,0]];
        let visited={};
        visited[0+"_"+0]=true;
        
        minHeap.insert([grid[0][0],0,0]);
        while(minHeap.getSize()>0){
            let item = minHeap.removeTop();
            let distance = item[0];
            let row = item[1];
            let col = item[2];
            if(row===grid.length-1 && col===grid[row].length-1){
                return distance;
            }
            for(let d=0;d<dx.length;d++){
                let i = row+dx[d][0];
                let j = col+dx[d][1];
                if(i>=0 && i<grid.length && j>=0 && j<grid[i].length && visited[i+"_"+j]===undefined){
                    if(distance+1>=grid[i][j]){
                        minHeap.insert([distance+1,i,j]);
                    }else{
                        let diff = grid[i][j]-distance;
                        let neighbhourDistance = grid[i][j];
                        if(diff%2===0){
                            neighbhourDistance++;
                        }
                        minHeap.insert([neighbhourDistance,i,j]);
                    }
                    visited[i+"_"+j] = true;
                }
            }
        }
        return -1;
    }
};