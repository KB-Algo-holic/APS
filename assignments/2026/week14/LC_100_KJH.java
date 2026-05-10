// LC same-tree
// 구현
// https://leetcode.com/problems/same-tree/
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        boolean rtn = false;

        if(p== null && q==null){
            rtn = true;
        }
        else if(q== null || p== null){
             rtn = false;
        }
        else if(p.val != q.val){
            rtn = false;
        }
        else if(p.val == q.val ){
             if(isSameTree(p.left ,q.left) && isSameTree(p.right ,q.right)){
                rtn =true;
             }
             else{
                rtn = false;
             }
        } 
        return rtn;
    }
}
