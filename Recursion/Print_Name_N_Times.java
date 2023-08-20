package Recursion;

public class Print_Name_N_Times {
    static void f(int i,int n){
        if(i>=n){
            return;
        }
        System.out.println("NAME");
        f(i+1,n);
    }
    public static void main(String[] args) {
        f(0,5);
    }
}
