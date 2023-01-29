package StackandQueues;

public class Stack_demo {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;


    Stack_demo()
    {
        this(DEFAULT_SIZE);
    }


    Stack_demo(int size){
        this.data = new int[size];
    }

    public boolean push(int item){

        if(ptr == data.length-1){
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception{
        if(ptr <0){
            throw new Exception("Cannot pop empty Stack");
        }
        
        return data[ptr--];
    }

    public int peek() throws Exception{
        if(ptr <0){
            throw new Exception("Cannot peek empty Stack");
        }
        return data[ptr];
    }

    public static void main(String[] args) throws Exception {
        Stack_demo stack = new Stack_demo(5);

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
