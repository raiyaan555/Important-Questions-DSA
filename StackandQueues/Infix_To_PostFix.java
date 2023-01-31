package StackandQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Infix_To_PostFix {

    public static String infixToPostfix(String exp) {
        {
            Map<Character, Integer> priority = new HashMap<>();
            priority.put('+', 1);
            priority.put('-', 1);
            priority.put('*', 2);
            priority.put('/', 2);
            priority.put('^', 3);
            priority.put('(', 0);
            Stack<Character> st = new Stack<>();
            String ans = "";

            for (int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);

                if (c == '(')
                    st.push(c);

                else if (c == ')') {
                    while (st.peek() != '(')
                        ans += st.pop();

                    st.pop();
                }

                else if (c == '+' || c == '-' || c == '*' || c == '^' || c == '/') {
                    while (!st.isEmpty() && priority.get(st.peek()) >= priority.get(c))
                        ans += st.pop();

                    st.push(c);
                }

                else
                    ans += c;
            }

            while (!st.isEmpty())
                ans += st.pop();

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
