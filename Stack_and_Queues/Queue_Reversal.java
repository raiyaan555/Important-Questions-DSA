package Stack_and_Queues;

import java.util.Queue;
import java.util.Stack;

public class Queue_Reversal {
    public Queue<Integer> rev(Queue<Integer> q) {

        Stack<Integer> s = new Stack<Integer>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        return q;

    }
}
