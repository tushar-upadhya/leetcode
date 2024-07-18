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
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);

        return count;
    }

    private List<Integer> helper(TreeNode root, int distance){
        if(root == null) return new ArrayList<>();

        if(root.left == null && root.right == null){
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            return subList;
        }

        List<Integer> list1 = helper(root.left, distance);
        List<Integer> list2 = helper(root.right, distance);

        for(int d1 : list1){
            for(int d2 : list2){
                if(d1 + d2 <= distance) count++;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int val : list1) list.add(val + 1);
        for(int val : list2) list.add(val + 1);

        return list;
    }
}