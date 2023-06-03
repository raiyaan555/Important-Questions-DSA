package Binary_Trees;

import java.util.ArrayList;
import java.util.Stack;

public class Boundary_Traversal {
    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false)
                res.add(cur.data);
            if (cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }

    static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.right;
        Stack<Integer> tmp = new Stack<>();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.push(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        while(!tmp.isEmpty()){
			res.add(tmp.pop());
		}
    }

    static void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null)
            addLeaves(root.left, res);
        if (root.right != null)
            addLeaves(root.right, res);
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode node) {
        // Write your code here.

        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (isLeaf(node) == false)
            ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;

    }
}
