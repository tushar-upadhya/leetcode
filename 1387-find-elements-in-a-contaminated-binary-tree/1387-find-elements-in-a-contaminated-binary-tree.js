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
 */
var FindElements = function(root) {
    this.recoveredValues = new Set();
    root.val = 0;
    this.recoverTree(root);
};

FindElements.prototype.recoverTree = function(root){
    if(!root) return;
    this.recoveredValues.add(root.val);

    if(root.left){
        root.left.val = 2 * root.val + 1;
        this.recoverTree(root.left);
    }
    if(root.right){
        root.right.val = 2 * root.val + 2;
        this.recoverTree(root.right);
    }
}

/** 
 * @param {number} target
 * @return {boolean}
 */
FindElements.prototype.find = function(target) {
    return this.recoveredValues.has(target);
};

/** 
 * Your FindElements object will be instantiated and called as such:
 * var obj = new FindElements(root)
 * var param_1 = obj.find(target)
 */