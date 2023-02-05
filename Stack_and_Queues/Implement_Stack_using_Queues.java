package Stack_and_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();

    public void push(int x) {
        int s = q1.size();

        q1.add(x);

        for (int i = 0; i < s; i++) {
            q1.add(q1.remove());
        }
    }

    public int pop() {
        if (q1.isEmpty())
            return -1;
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    public boolean empty() {
        if (q1.size() <= 0) {
            return true;
        }
        return false;
    }

}
