// [LC] 700 - Search in Binary Search Tree
// 재귀함수 이용하여 구현...
// 

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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        // 인풋 값이 현재 노드보다 작으면 왼쪽자식노드 탐색
        else if(root.val > val){
            return searchBST(root.left, val);
        }
        // 인풋 값이 현재 노드보다 크면 오른쪽자식노드 탐색
        else if(root.val < val){
            return searchBST(root.right, val);
        }
        else{
            return null;
        }
    }
}
