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
    List<Integer> singlePath = new ArrayList<>();
    List<List<Integer>> allPath = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return allPath;

        helper(root, target);

        return allPath;
    }

    private void helper(TreeNode root, int target){
        if(root == null) return;

        singlePath.add(root.val);

        if(root.left == null && root.right == null && target == root.val){
            allPath.add(new ArrayList<>(singlePath));
        }

        helper(root.left, target - root.val);
        helper(root.right, target - root.val);

        singlePath.remove(singlePath.size() - 1);
    }
}