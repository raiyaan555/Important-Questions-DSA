package Competitive_Coding;

import java.util.*;

public class Dont_Try_To_Count {
    public static void answer(String s, String x) {
        int c = 0;
        while (x.length() <= 1000) {
            if (x.indexOf(s) == -1) {
                x += x;
                c++;
            } else {
                System.out.println(c);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String x = sc.nextLine();
            String s = sc.nextLine();
            answer(s, x);
        }
    }
}

