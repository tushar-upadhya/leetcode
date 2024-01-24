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
    int paths = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root, new HashSet());
        return paths;
    }
    
    public void helper(TreeNode node, Set<Integer> num) {
        if (node == null) return;
        
        if (num.contains(node.val)) {
            num.remove(node.val);
        } else {
            num.add(node.val);
        }
        if (node.left == null && node.right == null) {
            paths += num.size() <= 1 ? 1 : 0;
            return;
        }
        helper(node.left, new HashSet(num));
        helper(node.right, new HashSet(num));
    }
}