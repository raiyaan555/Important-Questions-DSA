package Binary_Trees;

public class Diameter_Binary_Tree {
    public int height(TreeNode root, int[] d) {
        if (root == null)
            return 0;

        int lh = height(root.left, d);
        int rh = height(root.right, d);

        d[0] = Math.max(d[0], lh + rh);

        return 1 + (Math.max(lh, rh));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int d[] = new int[1];
        height(root, d);

        return d[0];

    }
}
