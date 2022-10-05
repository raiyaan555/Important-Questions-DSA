package Strings;

import java.util.*;

public class P3_Valid_Parenthesis {
    public static boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
                continue;
            }
            if (st.isEmpty())
                return false;
            char ch;
            switch (s.charAt(i)) {
                case ')':
                    ch = st.pop();
                    if (ch == '{' || ch == '[')
                        return false;
                    break;
                case '}':
                    ch = st.pop();
                    if (ch == '[' || ch == '(')
                        return false;
                    break;
                case ']':
                    ch = st.pop();
                    if (ch == '{' || ch == '(')
                        return false;
                    break;
            }

        }

        return st.isEmpty();

    }

    public static void main(String[] args) {
        String s = "{}()[";
        System.out.println(isValid(s));
    }
}


//  Another Solution


    // class Solution {
    //     public static boolean isValid(String s) {
    //          if(s.length() % 2 == 1)
    //          return false;
          
    //       Stack<Character> stack = new Stack<Character>();
    //       for(int i = 0; i < s.length(); i++)
    //       {
    //          if(s.charAt(i) == '(')
    //          {
    //              stack.push(')');
    //          }
    //          else if(s.charAt(i) == '{')
    //          {
    //              stack.push('}');
    //          }
    //          else if(s.charAt(i) == '[')
    //          {
    //              stack.push(']');
    //          }
    //          else if(stack.isEmpty() || stack.pop() != s.charAt(i))
    //              return false;
    //       }
    //       return stack.isEmpty();
    //  }
    //  }