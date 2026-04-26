// LC - 700 Search in a Binary Search Tree
// 트리
// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
public class LC_700_YHS {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);;

        if(left != null){
            return left;
        }else if(right != null){
            return right;
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
