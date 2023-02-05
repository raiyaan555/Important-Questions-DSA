package StackandQueues;

import java.util.Stack;

public class Next_Greater_Element {
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Integer> s = new Stack<>();
        long[] nxtGreater = new long[arr.length];

        for(int i=arr.length-1; i>=0; i--) {
           
            while(!s.isEmpty() && arr[s.peek()] <= arr[i])
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
