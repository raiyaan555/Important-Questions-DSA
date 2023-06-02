package Binary_Trees;

public class Maximum_Path_Sum {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxPathDown(root, ans);
        return ans[0];
    }

    public int maxPathDown(TreeNode node, int[] ans) {
        if (node == null)
            return 0;

        int left = Math.max(0, maxPathDown(node.left, ans));
        int right = Math.max(0, maxPathDown(node.right, ans));

        ans[0] = Math.max(ans[0], left + right + node.val);
        return Math.max(left, right) + node.val;

    }
}
