package Binary_Trees;

import java.util.HashMap;

public class Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder == null || postorder == null)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    TreeNode buildTree(int[] inorder, int iS, int iE, int[] postorder, int pS, int pE, HashMap<Integer, Integer> map) {

        if (iS > iE || pS > pE) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pE]);

        int inRoot = map.get(postorder[pE]);
        int numsLeft = inRoot - iS;

        root.left = buildTree(inorder, iS, inRoot - 1, postorder, pS, pS + numsLeft - 1, map);
        root.right = buildTree(inorder, inRoot + 1, iE, postorder, pS + numsLeft, pE - 1, map);

        return root;

    }
}
