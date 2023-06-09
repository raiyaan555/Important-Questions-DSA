package Binary_Trees;

public class Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int left = leftHeight(root);
        int right = rightHeight(root);
        
 
        if(left==right) return ((2<<left)-1);
        else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
     }
 
     int leftHeight(TreeNode root){
        
         int c = 0;
         while(root.left!=null){
             c++;
             root = root.left;
         }
         return c;
     }
 
     int rightHeight(TreeNode root){
        
         int c = 0;
         while(root.right!=null){
             c++;
             root = root.right;
         }
         return c;
     }
}
