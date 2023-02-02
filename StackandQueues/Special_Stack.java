package StackandQueues;

import java.util.Stack;

public class Special_Stack {
    public void push(int a,Stack<Integer> s)
	{
	    
	    s.push(a);
	   
	    //add code here.
	}
	public int pop(Stack<Integer> s)
        {
            
           return s.pop();
            
            //add code here.
	}
	public int min(Stack<Integer> s)
        {
            Stack<Integer> temp = s;
            int min = Integer.MAX_VALUE;
           //add code here.
           while(!isEmpty(temp)){
               if (temp.peek()<min){
                   min = temp.peek();
                   temp.pop();
               }else{
                   temp.pop();
               }
           }
           return min;
           
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
            return s.size() == n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
             return s.size() == 0;   
	}
}
