package Stack_and_Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_First_K_elements_of_Queue {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

        int size = q.size();

        Queue<Integer> ans = new LinkedList<Integer>();

        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        while (!q.isEmpty()) {
            ans.add(q.remove());
        }

        return ans;

    }
}
