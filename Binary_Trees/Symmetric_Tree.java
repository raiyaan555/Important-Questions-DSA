package Binary_Trees;

public class Symmetric_Tree {
    public class TreeNode {
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

    public boolean returnSym(TreeNode left, TreeNode right) {
        if (right == null || left == null)
            return left == right;

        if (right.val != left.val)
            return false;

        return returnSym(left.left, right.right) && returnSym(left.right, right.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return returnSym(root.left, root.right);
    }
}
