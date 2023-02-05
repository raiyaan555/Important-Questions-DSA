package Stack_and_Queues;

import java.util.Stack;

public class Stack_Permutations {
    public static int isStackPermutation(int n, int[] a, int[] b) {
        // code here
        
      Stack<Integer> st = new Stack<>();
       int index=0;
        for(int i=0;i<n;i++)
        {
             st.push(a[i]);
             while(!st.isEmpty() && st.peek()==b[index])
            {
                 st.pop();
                 index++;
            }
        }
        
        if(index==b.length && st.isEmpty())
            return 1;
        return 0;
    }
}
