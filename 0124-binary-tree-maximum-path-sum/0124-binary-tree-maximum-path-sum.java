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
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;

        helper(root, maxValue);

        return maxValue[0];
    }

    private int helper(TreeNode root, int maxValue[]){
        if(root == null) return 0;

        int lh = Math.max(0, helper(root.left, maxValue));
        int rh = Math.max(0, helper(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], lh + rh + root.val);

        return Math.max(lh, rh) + root.val;
    }
}