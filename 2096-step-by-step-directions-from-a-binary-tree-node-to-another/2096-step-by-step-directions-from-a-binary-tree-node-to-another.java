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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        StringBuilder b = new StringBuilder();

        helper(root, startValue, s);
        helper(root, destValue, b);
        
        int i = 0;
        int maxi = Math.min(b.length(), s.length());

        while(i < maxi && s.charAt(s.length() - i - 1) == b.charAt(b.length() - i - 1)) i++;

        return "U".repeat(s.length() - i) + b.reverse().toString().substring(i);
    }

    private boolean helper(TreeNode n, int val, StringBuilder sb){
        if(n.val == val) return true;

        if(n.left != null && helper(n.left, val, sb)) sb.append("L");
        else if(n.right != null && helper(n.right, val, sb)) sb.append("R");

        return sb.length() > 0;
    }
}