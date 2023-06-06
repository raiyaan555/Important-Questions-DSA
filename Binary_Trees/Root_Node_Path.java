package Binary_Trees;

import java.util.ArrayList;

public class Root_Node_Path {
    public static boolean isPathFound(TreeNode root, int x, ArrayList<Integer> path){
        if(root==null) return false;

       
        path.add(root.data);
        if(root.data==x) {  
            return true;
        }

        if(isPathFound(root.left, x,path) || isPathFound(root.right, x,path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;


    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> path = new ArrayList<>();
        if(root==null) return path;
        isPathFound(root, x,path);
        return path;
        
    }
}
