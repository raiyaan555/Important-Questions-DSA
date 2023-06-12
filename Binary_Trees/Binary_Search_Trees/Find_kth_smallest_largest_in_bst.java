package Binary_Trees.Binary_Search_Trees;

import org.w3c.dom.Node;

public class Find_kth_smallest_largest_in_bst {
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

    void solve(TreeNode root, int[] cnt, int[] ans, int k) {
        if (root == null)
            return;
        // left, root, right
        solve(root.left, cnt, ans, k);
        cnt[0]++;
        if (cnt[0] == k) {
            ans[0] = root.val;
            return;
        }
        solve(root.right, cnt, ans, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        int[] cnt = new int[1];
        solve(root, cnt, ans, k);
        return ans[0];
    }

    void returnNodes(TreeNode root, int[] h) {

        if (root == null) {
            return;
        }

        h[0]++;
        returnNodes(root.left, h);
        returnNodes(root.right, h);

    }

    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(TreeNode root, int K) {
        int[] ans = new int[1];
        int[] cnt = new int[1];
        int[] h = new int[1];

        returnNodes(root, h);

        solve(root, cnt, ans, h[0] - K + 1);
        return ans[0];
    }
}
