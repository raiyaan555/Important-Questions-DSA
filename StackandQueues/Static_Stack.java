package StackandQueues;

public class Static_Stack {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;


    Static_Stack()
    {
        this(DEFAULT_SIZE);
    }


    Static_Stack(int size){
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
        Static_Stack stack = new Static_Stack(5);

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
