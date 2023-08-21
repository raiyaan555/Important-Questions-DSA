package Recursion;

public class Fibonacci {

    public static int findFib(int n){
        if(n<=1) return n;

        return findFib(n-1)+findFib(n-2);
    }
     
    public static void main(String[] args) {
        System.out.println(findFib(6));
    }
}
