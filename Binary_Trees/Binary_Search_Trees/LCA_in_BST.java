package Binary_Trees.Binary_Search_Trees;

public class LCA_in_BST {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int curr = root.val;

        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        else {
            return root;
        }

    }
}
