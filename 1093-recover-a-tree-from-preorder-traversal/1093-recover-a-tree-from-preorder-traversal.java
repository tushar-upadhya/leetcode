/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        char ch[] = traversal.toCharArray();

        return helper(ch, 0, new int[]{0});
    }

    private TreeNode helper(char ch[], int d, int index[]){
        if(index[0] == ch.length) return null;
        int n = index[0];

        while(n != ch.length && ch[n] == '-'){
            n++;
        }

        if(n - index[0] != d) return null;
        index[0] = n;

        while(n < ch.length && ch[n] != '-') n++;

        TreeNode node = new TreeNode(charArrayToInt(ch, index[0], n));
        index[0] = n;
        node.left = helper(ch, d + 1, index);
        node.right = helper(ch, d + 1, index);

        return node;
    }
    private static int charArrayToInt(char arr[], int start, int end){
        int num = 0;

        for(int i = start; i < end; i++){
            num = num * 10 + (arr[i] - '0');
        }
        return num;
    }
}