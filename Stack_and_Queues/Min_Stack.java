package Stack_and_Queues;

import java.util.Stack;

public class Min_Stack {
    class Pair{
        int min;
        int ele;
    
        Pair(int ele, int min){
            this.min = min;
            this.ele = ele;
        }
    }
    class MinStack {
        Stack<Pair>st;
        public MinStack() {
            st = new Stack<>();
        }
        
        public void push(int val) {
            if(st.isEmpty()){
                st.push(new Pair(val,val));
            }else{
                 int a = st.peek().min;
                if(val<a){
                    st.push(new Pair(val,val));
                }else{
                    st.push(new Pair(val,a));
                }
            }
        }
        
        public void pop() {
            if(st.isEmpty()){
                return;
            }
            st.pop();
        }
        
        public int top() {
            return st.peek().ele;
        }
        
        public int getMin() {
            return st.peek().min;
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
