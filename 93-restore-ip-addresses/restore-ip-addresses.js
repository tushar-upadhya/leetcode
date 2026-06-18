/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    const result = [];

    function isValid(segment){
        if(segment.length > 1 && segment[0] === '0') return false;
        const num = Number(segment);
        return num >= 0 && num <= 255;
    }

    function backTrack(start, current){
        if(current.length === 4){
            if(start === s.length){
                result.push(current.join('.'));
            }
            return;
        }

        for(let length = 1; length <= 3; length++){
            if(start + length <= s.length){
                const segment = s.slice(start, start + length);

                if(isValid(segment)){
                    current.push(segment);
                    backTrack(start + length, current);
                    current.pop();
                }
            }
        }
    }
    backTrack(0, []);
    return result;
};