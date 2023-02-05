package Stack_and_Queues;

import java.util.Stack;

public class Expression_has_duplicate_parenthesis {

    static boolean findDuplicateparenthesis(String s) {
        

        Stack <Character> st = new Stack<>();

        char ch[] = s.toCharArray();

        for(char c: ch)
        {
            if(c !=')'){
                st.push(c);
            }else{
                if(st.peek()=='('){
                    return true;
                }
                while(st.peek()!='('){
                    st.pop();
                }
                st.pop();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
 
        // input balanced expression
        String str = "(a+(b)+(c+d)";
 
        if (findDuplicateparenthesis(str)) {
            System.out.println("Duplicate Found ");
        } else {
            System.out.println("No Duplicates Found ");
        }
 
    }
}
