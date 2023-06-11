package Binary_Trees.Binary_Search_Trees;

public class Ceil_In_BST {

    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here

        int ceil = -1;

        while (node != null) {

            if (node.data == x) {
                return node.data;
            } else if (x > node.data) {
                node = node.right;
            } else {
                ceil = node.data;
                node = node.left;
            }

        }
        return ceil;

    }
}
