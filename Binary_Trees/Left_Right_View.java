package Binary_Trees;

import java.util.ArrayList;

import Binary_Trees.Binary_Tree.Node;

public class Left_Right_View {
    public void returnLeftView(Node root, ArrayList<Integer> ans, int i){
        if(root==null) return;
        
        if(i==ans.size()){
            ans.add(root.data);
        }

        // this returns the left view
        
        returnLeftView(root.left, ans,i+1);
        returnLeftView(root.right, ans,i+1);


        // returning the right view 

        // returnLeftView(root.right, ans,i+1);
        // returnLeftView(root.left, ans,i+1);
    }
    
    
    ArrayList<Integer> leftView(Node root)
    {
      
      
      
      ArrayList<Integer> ans = new ArrayList<>();
      returnLeftView(root,ans,0);
      return ans;
      
      
      
    }
}
