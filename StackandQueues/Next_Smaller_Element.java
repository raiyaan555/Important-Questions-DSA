package StackandQueues;

import java.util.Stack;

public class Next_Smaller_Element {
    public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> s = new Stack<>();
       int[] nxtGreater = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--) {
           
            while(!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();

            
            if(s.isEmpty())
                nxtGreater[i] = -1;
            else
                nxtGreater[i] = arr[s.peek()];

            
            s.push(i);
        }
        return nxtGreater;
    } 
}
