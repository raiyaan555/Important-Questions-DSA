package Competitive_Coding;

import java.util.Scanner;

public class The_New_Year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int first = 0, second = 0, last = 0;

        if (a >= b && a >= c) {
            last = a;
            if (b > c) {
                second = b;
                first = c;
            } else {
                second = c;
                first = b;
            }

        } else if (b >= a && b >= c) {
            last = b;
            if (a > c) {
                second = a;
                first = c;
            } else {
                second = c;
                first = a;
            }
        } else if (c >= a && c >= b) {
            last = c;
            if (a > b) {
                second = a;
                first = b;
            } else {
                second = b;
                first = a;
            }
        }

        System.out.println((second - first) + (last - second));
    }
}
