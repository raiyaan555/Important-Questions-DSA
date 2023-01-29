package StackandQueues;

public class Circular_Queues {
    private static final int DEFAULT_SIZE = 10;
    int[] data;

    int end = 0;
    int front = 0;
    int size = 0;

    public Circular_Queues() {
        this(DEFAULT_SIZE);
    }

    public Circular_Queues(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (end == data.length) {
            return false;
        }

        data[end++] = item;
        end = end % data.length;
        size++;
        return true;

    }

    public int remove() throws Exception {
        if (end < 0) {
            throw new Exception("Cannot remove empty Queue");
        }
        int rem = data[front++];
        front = front % data.length;
        size--;

        return rem;
    }

    public static void main(String[] args) throws Exception {
        Custom_Queues que = new Custom_Queues(5);

        que.insert(1);
        que.insert(2);
        que.insert(3);
        que.insert(4);
        que.insert(5);

        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());

    }
}
