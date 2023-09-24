package Competitive_Coding;
import java.util.Arrays;
import java.util.Scanner;

public class Rigged {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            int c1 = 0;
            int c2 = 0;
            Arrays.sort(a);
            Arrays.sort(b);

            for (int i = 0; i < n; i++) {
                c1 += a[0] + b[i];
                c2 += b[0] + a[i];
            }

            System.out.println(Math.min(c1, c2));
        }
    }
}
