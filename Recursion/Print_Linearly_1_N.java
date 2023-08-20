package Recursion;

public class Print_Linearly_1_N {
    public static void iterate(int i, int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        iterate(i+1, n);

    }
    public static void main(String[] args) {
        iterate(1, 5);
    }
}
