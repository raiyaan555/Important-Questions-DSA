package Binary_Trees.Binary_Search_Trees;

import java.util.Stack;

public class BST_Iterator {

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
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public void BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp  = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    void pushAll(TreeNode node){
        for(;node!=null;stack.push(node),node = node.left);
    }
}
