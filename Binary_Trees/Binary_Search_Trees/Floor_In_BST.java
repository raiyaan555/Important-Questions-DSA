package Binary_Trees.Binary_Search_Trees;

public class Floor_In_BST {

    class TreeNode<T> {

        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public static int floorInBST(TreeNode<Integer> root, int X) {
            // Write your code here.
            int floor = -1;

            while (root != null) {
                if (root.data == X) {
                    return X;
                } else if (root.data > X) {
                    root = root.left;
                } else {
                    floor = root.data;
                    root = root.right;
                }
            }
            return floor;
        }
    }
}
