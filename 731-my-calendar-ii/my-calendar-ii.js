
var MyCalendarTwo = function() {
    this.overlaps = []
    this.events = []
};

/** 
 * @param {number} start 
 * @param {number} end
 * @return {boolean}
 */
MyCalendarTwo.prototype.book = function(start, end) {
    if(this.events.length < 2){
        this.events.push([start, end])
        return true;
    }

    this.overlaps = []
    for(let i = 0; i < this.events.length; i++){
        if(end > this.events[i][0] && start < this.events[i][1]){
            const overlap = this.helper(this.events[i], [start, end])

            for(let j = 0; j < this.overlaps.length; j++){
                if(overlap[1] > this.overlaps[j][0] && overlap[0] < this.overlaps[j][1]) return false;

            }
            this.overlaps.push(overlap)
        }
    }
    this.events.push([start, end])
    return true;
};

MyCalendarTwo.prototype.helper = function(region1, region2){
    const [start1, end1] = region1;
    const [start2, end2] = region2;
    const start = Math.max(start1, start2);
    const end = Math.min(end1, end2);

    return [start, end];
}


/** 
 * Your MyCalendarTwo object will be instantiated and called as such:
 * var obj = new MyCalendarTwo()
 * var param_1 = obj.book(start,end)
 */