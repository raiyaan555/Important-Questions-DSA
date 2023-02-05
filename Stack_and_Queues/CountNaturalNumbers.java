package Stack_and_Queues;

import java.util.Stack;

public class CountNaturalNumbers {
    static int countNumber(int n) {
        int result = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 1; i <= 9; i++) {
            if (i <= n) {
                st.push(i);
                result += 1;
            }
        }

        while (!st.isEmpty()) {
            int t = st.pop();
            for (int i = t % 10; i <= 9; i++) {
                if ((t * 10 + i) <= n) {
                    st.push((t * 10 + i));
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(countNumber(n));
    }

}
