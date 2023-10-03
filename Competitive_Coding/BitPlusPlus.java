package Competitive_Coding;

import java.util.Scanner;

public class BitPlusPlus {
    static int sum = 0;

    public static int bitcall(String s) {

        String a = "++X";
        String b = "X++";

        if (s.equalsIgnoreCase(a) || s.equalsIgnoreCase(b)) {
            return ++sum;
        } else
            return --sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            String s = sc.next();
            System.out.println(bitcall(s));
        }
    }
}
