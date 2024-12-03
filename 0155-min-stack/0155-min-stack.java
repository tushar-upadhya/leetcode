class MinStack {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> minstack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        s1.push(val);
        if(minstack.isEmpty()|| val<=minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        if(s1.peek().equals(minstack.peek())){
            minstack.pop();
        }
        s1.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */