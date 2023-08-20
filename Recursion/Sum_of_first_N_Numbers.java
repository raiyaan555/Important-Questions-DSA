package Recursion;

public class Sum_of_first_N_Numbers {
    static int sum = 0;
    public static void findSum(int i, int N){
        if(i>N)
        return;
        sum +=i;
        findSum(i+1, N);
    }
    public static void main(String[] args) {
        findSum(1, 10);
        System.out.println(sum);
    }
}
