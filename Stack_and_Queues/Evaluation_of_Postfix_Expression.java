package Stack_and_Queues;

import java.util.Stack;

public class Evaluation_of_Postfix_Expression {
    public static int evaluatePostFix(String S) {
        Stack<Integer> stack = new Stack<>();
        char ch[] = S.toCharArray();
        for (char i : ch) {
            if (i >= '0' && i <= '9') {
                stack.push((int) i - '0');
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch (i) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op1 / op2);
                        break;

                }

            }

        }

        return stack.pop();
    }
    
    public static void main(String[] args) {
        String S = "123+*8-";

        System.out.println(evaluatePostFix(S));
    }

}
