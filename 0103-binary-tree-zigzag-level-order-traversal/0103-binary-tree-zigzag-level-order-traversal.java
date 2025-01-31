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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return Collections.emptyList();
        }

        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        int level = 1;

        ms.push(root);

        while(!ms.isEmpty()){
            List<Integer> row = new ArrayList<>();

            while(!ms.isEmpty()){
                TreeNode node = ms.pop();
                row.add(node.val);

                if(level % 2 == 1){
                    if(node.left != null){
                        cs.push(node.left);
                    }
                    if(node.right != null){
                        cs.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        cs.push(node.right);
                    }
                    if(node.left != null){
                        cs.push(node.left);
                    }
                }
            }
            result.add(row);
            level++;
            ms = cs;
            cs = new Stack<>();
        }
        return result;
    }
}