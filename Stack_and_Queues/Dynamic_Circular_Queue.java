package Stack_and_Queues;

public class Dynamic_Circular_Queue extends Circular_Queues {
    public Dynamic_Circular_Queue() {
        super();
    }

    public Dynamic_Circular_Queue(int size) {
        super(size);
    }

    @Override

    public boolean insert(int items) {
        if (end == data.length) {

            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Dynamic_Circular_Queue que = new Dynamic_Circular_Queue(5);

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