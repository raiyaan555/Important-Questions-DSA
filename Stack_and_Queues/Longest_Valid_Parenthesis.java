package Stack_and_Queues;

import java.util.Stack;

public class Longest_Valid_Parenthesis {
    static int maxLength(String S){
        // code here
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        int count = Integer.MIN_VALUE;
       for(int i = 0; i<S.length();i++){
        char c = S.charAt(i);
            if(c=='('){
               st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    count = Math.max(count, i-st.peek());
                }

            }
        }
        return count;
    }
}
