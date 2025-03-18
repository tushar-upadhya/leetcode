/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
            
            q.add(root);

            while(!q.isEmpty()){
                TreeNode nd = q.poll();
                if(nd == null){
                    result.append("n ");
                    continue;
                }

                result.append(nd.val + " ");
                
                q.add(nd.left);
                q.add(nd.right);

            }
            return result.toString();
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] values = data.split(" ");
       Queue<TreeNode> q = new LinkedList<>();
       TreeNode root = new TreeNode(Integer.parseInt(values[0]));
       
       q.add(root);

       for(int i = 1; i < values.length; i++){
            TreeNode parent = q.poll();

            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }

            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
       }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));