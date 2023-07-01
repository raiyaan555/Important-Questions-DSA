package Dynamic_Programming;

import java.util.Arrays;

// Memoization
 
public class Fibonacci {

    public static int fib(int n, int[] dp) {

        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);

    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fib(n, dp));

    }

    // Tabulation
    
     public static int fibTab(int n, int[] dp) {

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];

    }


    // Space optimization


    public static int fib3(int n) {

        int prev2 = 0;
        int prev= 1;
        int curr = -1;

        for(int i = 2; i<=n;i++){
          curr = prev+prev2;
          prev2 = prev;
          prev = curr;
        }

        return prev;

    }
}
