class Trie {
    Trie[] arr = new Trie[26];
    int count = 0;
}
class Solution {

    Trie root = new Trie();

    private void helper(String str) {
        Trie curr = root;
        int index;
        for(char ch : str.toCharArray()) {
            index = ch - 'a';
            if(curr.arr[index] == null) curr.arr[index] = new Trie();
            curr = curr.arr[index];
            curr.count++;
        }
    }
    int getValue(String str) {
        Trie curr = root;
        int index;
        int count = 0;
        for(char ch : str.toCharArray()) {
            index = ch - 'a';
            if(curr.arr[index] == null) return count;
            curr = curr.arr[index];
            count += curr.count;
        }
        return count;
    }
    public int[] sumPrefixScores(String[] words) {
        for(String str : words) {
            helper(str);
        }
        int result[] = new int[words.length];
        int index = 0;
        for(String str : words) {
            result[index++] = getValue(str);
        }
        return result;
    }
}