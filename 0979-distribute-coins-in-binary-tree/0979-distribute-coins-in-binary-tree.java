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
    private int result;
    public int distributeCoins(TreeNode root) {
        result = 0;
        
        helper(root);
        
        return result;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        
        int leftCoins = helper(root.left);
        int rightCoins = helper(root.right);
        
        result += Math.abs(leftCoins) + Math.abs(rightCoins);
        
        return (root.val - 1) + leftCoins + rightCoins;
    }
}