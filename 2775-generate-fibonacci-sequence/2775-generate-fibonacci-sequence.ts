function* fibGenerator(): Generator<number> {
    let a = 0;
    let b = 1;

    while (true){
        yield a;
        [a, b] = [b, a+b];
    }
};
