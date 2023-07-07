package Competitive_Coding;

import java.util.*;

public class Rudolph_Cut_Rope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        while (N-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int c = 0;

            for (int i = 0; i < n; i++) {
                    if (a[i][0] > a[i][1]) {
                        c++;
                    }
                
            }
            System.out.println(c);

        }
    }

}
