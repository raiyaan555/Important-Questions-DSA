package Competitive_Coding;

import java.util.*;

public class Beautiful_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    ans = Math.abs(i-3)+Math.abs(j-3);
                }
            }
        }
        System.out.println(ans);
    }
}
