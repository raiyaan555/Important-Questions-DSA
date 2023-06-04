package Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import Binary_Trees.Binary_Tree.Node;

public class Top_View {
    class Pair{
        Node node;
       int hd;
         Pair(Node n,int h){
             node=n;
             hd=h;
         }
     }
     
     ArrayList<Integer> topView(Node root)
     {
       
 
         // add your code
         
         ArrayList<Integer> ans=new ArrayList<Integer>();
         Queue<Pair> q=new LinkedList<>();
         TreeMap<Integer,Integer> hm=new TreeMap<>();
         q.add(new Pair(root,0));
         while(!q.isEmpty()){
             Pair p=q.poll();
             int hd=p.hd;
             Node curr=p.node;
             if(!hm.containsKey(hd)){
                 hm.put(hd,curr.data);
             }
             if(curr.left!=null){
                 q.add(new Pair(curr.left,hd-1));
             }
             if(curr.right!=null){
                 q.add(new Pair(curr.right,hd+1));
             }
         }
       for(Integer mp:hm.values()){
           ans.add(mp);
       }
        return ans;
     }
}
