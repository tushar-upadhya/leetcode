/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);

        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else return root;
    }
}