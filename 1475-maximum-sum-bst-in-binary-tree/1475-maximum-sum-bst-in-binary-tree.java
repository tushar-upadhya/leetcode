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
class nodeValue{
    public int maxValue, minValue, maxSum;
    
    public nodeValue(int maxValue, int minValue, int maxSum){
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.maxSum = maxSum;
    }
}

class Solution {
    int max = 0;
    public nodeValue helper(TreeNode root){
        if(root == null) return new nodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        nodeValue left = helper(root.left);
        nodeValue right = helper(root.right);
        if(left.maxValue < root.val && root.val < right.minValue){
            max = Math.max(max,root.val + left.maxSum + right.maxSum);
            return new nodeValue(Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue), root.val + left.maxSum + right.maxSum);
        }
        return new nodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSum, right.maxSum));
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
}