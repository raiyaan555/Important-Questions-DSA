package Linked_List;



public class Flatenning_LinkedList {
    class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
    Node mergeNodes(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        
        while(a!=null && b!=null){
            if(a.data<b.data){
             temp.bottom = a;
             temp = temp.bottom;
             a = a.bottom;
            }else{
             temp.bottom = b;
             temp = temp.bottom;
             b = b.bottom;
            }
        }
        
        temp.bottom = a!=null ?a:b;
        return res.bottom;
    }
    
    Node flatten(Node root)
    {
        
        // base case
        
        if(root==null || root.next==null ) return null;
        
        // recur till the last node on the right
        
        root.next = flatten(root.next);
        
        // now merge
        
        root = mergeNodes(root,root.next);
        
        
        return root;

    }
}
