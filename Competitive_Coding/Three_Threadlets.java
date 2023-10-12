package Competitive_Coding;

import java.util.Scanner;

public class Three_Threadlets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();

            int minT = Math.min(a, Math.min(b, c));
            boolean position = true;
            int count = 0;

            if (a % minT != 0 || b % minT != 0 || c % minT != 0) {
                position = false;
            }

            while (a != minT) {
                if (a % minT != 0 || count > 3) {
                    position = false;
                    break;
                }
                a -= minT;
                count++;
            }

            while (b != minT) {
                if (b % minT != 0 || count > 3) {
                    position = false;
                    break;
                }
                b -= minT;
                count++;
            }

            while (c != minT) {
                if (c % minT != 0 || count > 3) {
                    position = false;
                    break;
                }
                c -= minT;
                count++;
            }

            if (count > 3) {
                position = false;
            }

            if (position) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
