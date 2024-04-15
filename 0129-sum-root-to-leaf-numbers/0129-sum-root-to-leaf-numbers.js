/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
    function helper(node, sum){
        if(!node) return null;
        
        sum += node.val;
        if(!node.left && !node.right) return +sum;
        
        return helper(node.left, sum) + helper(node.right, sum);
    }
    return helper(root, '')
};