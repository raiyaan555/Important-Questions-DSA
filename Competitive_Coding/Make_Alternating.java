package Competitive_Coding;

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Make_Alternating {
   


    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            solve(s);
        }
    }

    static void solve(String s) {
        int minstp = 0;
        List<Integer> pr = new ArrayList<>();
        int c = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                minstp++;
                c++;
            } else {
                if (c >= 2) {
                    pr.add(c);
                }
                c = 1;
            }

            if (i == s.length() - 1) {
                if (c >= 2) {
                    pr.add(c);
                }
            }
        }

        int sm = 0;
        for (int i : pr) {
            sm += i;
        }

        int ed = 2 * pr.size();
        int ans = 1;

        for (int i = sm; i > ed; i--) {
            ans = (int) ((long) ans * i % MOD);
        }

        for (int i = ed; i >= 2; i -= 2) {
            ans = (int) ((long) ans * i % MOD);
        }

        System.out.println(minstp + " " + ans);
    }
}
