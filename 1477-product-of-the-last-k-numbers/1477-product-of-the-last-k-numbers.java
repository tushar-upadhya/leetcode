class ProductOfNumbers {

    private List<Long> values;
    private long product;
    
    public ProductOfNumbers() {
        values = new ArrayList<>();
        product = 1;    
    }
    
    public void add(int num) {
        if(num == 0){
            values.clear();
            product = 1;
        }else{
            product *= num;
            values.add(product);
        }
    }
    
    public int getProduct(int k) {
        if(k > values.size()){
            return 0;
        }
        long divisor = (k == values.size()) ? 1 : values.get(values.size() - k - 1);

        return (int) (values.get(values.size() - 1) / divisor);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */