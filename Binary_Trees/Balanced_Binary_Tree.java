package Binary_Trees;

public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        //Approach: Using Recursion, T.C: O(n), n is the number of nodes in the tree
        //S.C: O(h), h is the height of the tree 
        //base case
        if(root==null) return true;
        //here we are using absolute value, because the difference can be negative
        //negative value doesn't matter here, because we need balance, if not 
        //then just return false
        if(Math.abs(height(root.left)-height(root.right))>1){
            return false;
        }

        //now just call recursion for other subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //function to find the height
    public int height(TreeNode root){
        if(root==null) return 0;

        //we are adding 1 heare, because we have to consider the root also
        int lh = 1+height(root.left);
        int rh = 1+height(root.right);

        return Math.max(lh, rh);
    }
}
