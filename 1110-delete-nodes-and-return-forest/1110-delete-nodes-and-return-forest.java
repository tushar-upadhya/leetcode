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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < to_delete.length; i++){
            set.add(to_delete[i]);
        }
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list = helper(root, set, list, null);
        
        if(!set.contains(root.val)){
            list.add(root);
        }
        return list;
    }
    
    private static ArrayList<TreeNode> helper(TreeNode root, HashSet<Integer> set, ArrayList<TreeNode> list, TreeNode parent){
        if(root == null) return list;
        list = helper(root.left, set, list, root);
        list = helper(root.right, set, list, root);
        
        if(set.contains(root.val)){
            if(root.left != null && !set.contains(root.left.val)){
                list.add(root.left);
                root.left = null;
            }
            
            if(root.right != null && !set.contains(root.right.val)){
                list.add(root.right);
                root.right = null;
            }
            
            if(parent != null){
                if(parent.left != null && parent.left.val == root.val){
                    parent.left = null;
                }
                if(parent.right != null && parent.right.val == root.val){
                    parent.right = null;
                }
            }
        }
        return list;
    }
}