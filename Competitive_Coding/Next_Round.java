package Competitive_Coding;

import java.util.Scanner;

public class Next_Round {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n + 1];
        int minScore = 0;
        for (int i = 1; i <= n; i++) {
            int score = sc.nextInt();
            data[i] = score;
            if (i == k)
                minScore = score;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (data[i] >= minScore && data[i] > 0)
                cnt++;
        }

        System.out.println(cnt);
    }
}
