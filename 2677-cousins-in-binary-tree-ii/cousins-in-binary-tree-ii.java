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
    int lmax = 0;
    long[] sums = new long[1000001];

    public TreeNode replaceValueInTree(TreeNode root) {
        traverse(root, 0);
        int left = root.left != null ? root.left.val:0;
        int right = root.right != null ? root.right.val:0;
        sum(root, 0, left + right);
        return root;
    }
    
    private void traverse(TreeNode node, int a){
        if(node == null)
           return;

        if(a >= lmax){
            sums[lmax++] = node.val;
        }
        else{
            sums[a] += node.val;
        }
        traverse(node.left, a + 1);
        traverse(node.right, a + 1);
    }
    
    private void sum(TreeNode a,int level, int s){
        if(a == null) return;
        
        if(level == 0)
            a.val = 0;
        else{
            a.val = (int)sums[level]-s;
        }
        int l = a.left != null ? a.left.val:0;
        int r = a.right !=null ? a.right.val:0;
        sum(a.left, level + 1, l + r);
        sum(a.right,level + 1, l + r);
    }
}