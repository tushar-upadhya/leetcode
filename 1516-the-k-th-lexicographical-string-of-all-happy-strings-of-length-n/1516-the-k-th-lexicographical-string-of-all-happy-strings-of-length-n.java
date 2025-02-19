class Solution {
    public String getHappyString(int n, int k) {

        Queue<String> q = new LinkedList<>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        List<String> happyStrings = new ArrayList<>();
        
        while (!q.isEmpty()) {
            String str = q.poll();
            if (str.length() == n) {
                happyStrings.add(str);
                continue;
            }
            for (char ch : new char[]{'a', 'b', 'c'}) {
                if (str.charAt(str.length() - 1) != ch) {
                    q.offer(str + ch);
                }
            }
        }
        
        return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
    }
}