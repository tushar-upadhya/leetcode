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
    List<TreeNode> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        helper(root);
        int start = 0;
        int end = list.size() - 1;

        return createBST(start, end);    
    }

    private void helper(TreeNode root){
        if(root == null){
            return;
        }

        helper(root.left);
        list.add(root);
        helper(root.right);
    }

    private TreeNode createBST(int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = list.get(mid);
        root.left = createBST(start, mid - 1);
        root.right = createBST(mid + 1, end);

        return root;
    }
}