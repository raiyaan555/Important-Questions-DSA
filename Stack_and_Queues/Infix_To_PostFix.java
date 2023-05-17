package Stack_and_Queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Infix_To_PostFix {

    public static String infixToPostfix(String s) {
        {
            HashMap<Character, Integer> map = new HashMap<>();
            Stack<Character> st = new Stack<>();
            String ans = "";
            
            map.put('+',1);
            map.put('-',1);
            map.put('*',2);
            map.put('/',2);
            map.put('^',3);
            map.put('(',0);
            
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                
                if(c=='('){
                    st.push(c);
                }
                else if(c==')'){
                    while(st.peek()!= '(')
                        ans += st.pop();
                        st.pop();
                    
                }
                
                else if(c=='+'||c=='-'||c=='/'||c=='*'||c=='^'){
                    while(!st.isEmpty() && map.get(st.peek())>= map.get(c)){
                        ans +=st.pop();
                    }
                    st.push(c);
                }
                
                else{
                    ans +=c;
                }
            }
            
            while(!st.isEmpty()){
                ans+=st.pop();
            }
            return ans;
        }


       

    }

    public static void main(String[] args) {
        Infix_To_PostFix a = new Infix_To_PostFix();
        String s1 = a.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println(s1);

        String s2 = a.infixToPostfix("2+3*4");
        System.out.println(s2);

        String s3 = a.infixToPostfix("3*(4+5)-6/(1+2)");
        System.out.println(s3);
    }
}
