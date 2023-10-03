package Competitive_Coding;
import java.util.*;
public class Soft_Drinking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, l, c, d, p, nl, np;
        n = sc.nextInt();
        k = sc.nextInt();
        l = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        p = sc.nextInt();
        nl = sc.nextInt();
        np = sc.nextInt();

        int drinks = (k*l)/nl;
        int limes = c*d;
        int salt = p/np;

        int ans = Math.min(drinks,Math.min(limes,salt))/n;
        System.out.println(ans);

    }
}
