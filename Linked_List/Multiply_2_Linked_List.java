package Linked_List;

public class Multiply_2_Linked_List {
    class Node
{
    int data; 
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
    
    public long multiplyTwoLists(Node l1,Node l2){
        //add code here.
        
        Node curr1 = l1;
        long data1 = 0;
        
        while(curr1!=null){
            data1 = (data1*10+curr1.data)%1000000007;
            curr1 = curr1.next;
        }
        Node curr2 = l2;
        long data2 = 0;
        
        while(curr2!=null){
            data2 = (data2*10+curr2.data)%1000000007;
            curr2 = curr2.next;
        }
        
        return (data1*data2)%1000000007;
        }
        
       
        
        
 }
}
