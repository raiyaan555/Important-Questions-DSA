package Stack_and_Queues;

import java.util.Stack;

public class Sort_a_stack {
    
    public static void insert_right_pos(int x, Stack<Integer> s){
        if(s.isEmpty() || s.peek()<x){
            s.push(x);
        }else{
            int a = s.peek();
            s.pop();
            insert_right_pos(x,s);
            s.push(a);
        }
    }
    public static void reverse(Stack<Integer> s){
        if(!s.isEmpty()){
            int x = s.peek();
            s.pop();
            reverse(s);
            insert_right_pos(x,s);
        }
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
	
	reverse(s);
	return s;
	}
    
}
