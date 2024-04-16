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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        helper(root, val, depth, 1);
        return root;
    }
    private void helper(TreeNode node, int value, int depth, int currentDepth){
        if(node == null) return;
        
        if(depth - 1 == currentDepth){
            TreeNode tree = node.left;
            node.left = new TreeNode(value);
            node.left.left = tree;
            tree = node.right;
            node.right = new TreeNode(value);
            node.right.right = tree;
        }else{
            helper(node.left, value, depth, currentDepth + 1);
            helper(node.right, value, depth, currentDepth + 1);
        }
    }
}