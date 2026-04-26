package week12;

public class LC_700_HSH {
    public static void main(String[] args) {
        LC_700_HSH sol = new LC_700_HSH();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;

        TreeNode result = sol.searchBST(root, val);

        if (result != null) {
            System.out.println("찾은 노드 값: " + result.val);

            if (result.left != null) {
                System.out.println("왼쪽 자식: " + result.left.val);
            }

            if (result.right != null) {
                System.out.println("오른쪽 자식: " + result.right.val);
            }
        } else {
            System.out.println("해당 값을 가진 노드가 없습니다.");
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // val 값을 가진 노드를 찾고, 그 노드를 루트로 하는 서브트리를 반환
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}