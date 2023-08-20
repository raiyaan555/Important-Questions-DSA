package Recursion;
import java.util.*;

class Print_From_N_1{

    public static  void printOpposite(int i){
        if(i==0){
            return;
        }
        System.out.println(i);
        printOpposite(i-1);
    }
    public static void main(String[] args) {
        printOpposite(5);
    }
}