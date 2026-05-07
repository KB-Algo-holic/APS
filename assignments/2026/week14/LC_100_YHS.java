// LC - 100 Same Tree
// 재귀
// https://leetcode.com/problems/same-tree/description/
public class LC_100_YHS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compareTree(p, q);
    }

    boolean compareTree(TreeNode p, TreeNode q){

        if(p == null && q == null) return true;

        if((p == null && q != null) || (p != null && q == null)) return false;

        // if((p.left == null && q.left != null) || (p.left != null && q.left == null))  false; // 이건필요없을지도?

        if(p.val != q.val) return false;

        return compareTree(p.left, q.left) && compareTree(p.right, q.right);
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
