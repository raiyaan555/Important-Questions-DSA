package Recursion;

public class Factorial {
    static int fact = 1;
    public static void findSum(int i, int N){
        if(i>N)
        return;
        fact *=i;
        findSum(i+1, N);
    }
    public static void main(String[] args) {
        findSum(1, 5);
        System.out.println(fact);
    }   
}
