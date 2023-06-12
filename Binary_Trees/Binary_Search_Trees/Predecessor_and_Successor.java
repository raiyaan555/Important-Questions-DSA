package Binary_Trees.Binary_Search_Trees;



public class Predecessor_and_Successor {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static Node pre, suc;

    public static void findPreSuc(Node root, int key) {
        if (root.data < key) {
            if (pre == null || pre.data < root.data)
                pre = root;
        } else if (root.data > key) {
            if (suc == null || suc.data > root.data)
                suc = root;
        }

        if (root.left != null)
            findPreSuc(root.left, key);
        if (root.right != null)
            findPreSuc(root.right, key);
    }
}
