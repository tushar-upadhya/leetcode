class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int result[] = new int[n];
        
        for(int i = 0; i < n; i++){
            while(stack.size() > 0 && temperatures[i] > temperatures[stack.peek()])
                result[stack.peek()] = i - stack.pop();
            
            stack.push(i);
        }
        return result;
    }
}