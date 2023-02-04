package StackandQueues;

import java.util.Stack;

public class The_Celebrity_Problem {
    int celebrity(int M[][], int n) {
        // code here
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (M[i][j] == 1) {
                // if i knows j, i not celebrity
                st.push(j);

            } else {
                // if i does not know j, j not celebrity
                st.push(i);
            }
        }

        int pot = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != pot) {
                if (M[i][pot] == 0 || M[pot][i] == 1) {
                    return -1;
                }
            }
        }

        return pot;

    }
}
