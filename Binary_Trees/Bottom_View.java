package Binary_Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Binary_Trees.Binary_Tree.Node;

public class Bottom_View {
    class Solution
{
    
    static class Info{
        Node node;
        int hd;
        
        Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> view = new ArrayList<>();
        
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        
        q.add(new Info(root,0));
        q.add(null);
        
        
        int min = 0;
        int max = 0;
        
        while(!q.isEmpty())
        {
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                map.put(curr.hd,curr.node);
                
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd - 1));
                    min = Math.min(min,curr.hd-1);
                }
                    
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd + 1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        
        for(int i = min;i<=max;i++){
            view.add(map.get(i).data);
        }
        
        return view;
    }
}
}
