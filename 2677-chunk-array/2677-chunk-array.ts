type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function chunk(arr: Obj[], size: number): Obj[][] {
    const chunk: any[][] = []
    
    for(let i = 0; i < arr.length; i++){
        chunk.push(arr.slice(i, i + size));
        i += size - 1;
    }
    return chunk
};
