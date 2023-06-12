package Binary_Trees.Binary_Search_Trees;

public class Validate_BST {
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

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, Long minValue, Long maxValue) {

        if (root == null)
            return true;
        if (root.val >= maxValue || root.val <= minValue)
            return false;

        return isValid(root.left, minValue, (long) root.val) && isValid(root.right, (long) root.val, maxValue);
    }
}
