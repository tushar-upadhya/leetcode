class StockSpanner {

    static class Node{
        int val;
        int del;

        public Node(int val, int del){
            this.val = val;
            this.del = del;
        }
    }

    Stack<Node> stack;

    public StockSpanner() {
        stack = new Stack<>();    
    }
    
    public int next(int price) {
        int count = 0;
        while(!stack.isEmpty() && stack.peek().val <= price){
            count += stack.peek().del;
            stack.pop();
        }
        count++;
        stack.push(new Node(price, count));
        return count;
    }

}   

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */