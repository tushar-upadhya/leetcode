class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    private TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend,
            HashMap<Integer, Integer> map) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        

        int inroot = map.get(root.val);
        int inleft = inroot - instart;

        root.left = helper(preorder, prestart + 1, inleft + prestart, inorder, instart, inroot - 1,map);
        root.right = helper(preorder, prestart + inleft + 1, preend, inorder, inroot + 1, inend,map);
        return root;

    }
}