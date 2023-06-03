package Binary_Trees;

public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==q;
        }

    return (p.val == q.val) && isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
        
    }
}
