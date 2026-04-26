// LC 700 - Search in a Binary Search Tree
// 유형: 구현
// 링크: https://leetcode.com/problems/search-in-a-binary-search-tree/description/
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
 * @param {number} val
 * @return {TreeNode}
 */
var searchBST = function (root, val) {
    while (root !== null) {
        if (root.val === val) {
            return root;
        }
        if (val < root.val) {
            root = root.left;
        }
        else {
            root = root.right;
        }
    }
    return null;
};