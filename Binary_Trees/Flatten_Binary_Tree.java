package Binary_Trees;

public class Flatten_Binary_Tree {
    TreeNode prev = null;
    public void flatten(TreeNode node) {
       
        if(node==null) return;

        flatten(node.right);
        flatten(node.left);
        node.right = prev;
        node.left = null;
        prev = node;
        
    } 
}
