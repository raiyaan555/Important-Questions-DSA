package Stack_and_Queues;

public class Dynamic_Stack extends Static_Stack {

    Dynamic_Stack() {
        super();
    }

    Dynamic_Stack(int size) {
        super(size);
    }

    @Override

    public boolean push(int item) {
        if (ptr == data.length - 1) {
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        return super.push(item);
    }

    public static void main(String[] args) throws Exception {
       Dynamic_Stack stack = new  Dynamic_Stack(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
