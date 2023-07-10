package Dynamic_Programming;

class Rod_Cutting {
    public int f(int i, int n, int[] price, int dp[][]) {
        if (i == 0) {
            return (n / 1) * price[0];
        }
        if (dp[i][n] != -1)
            return dp[i][n];

        int notTake = f(i - 1, n, price, dp);
        int take = (int) -1e9;
        int rodLength = i + 1;
        if (rodLength <= n)
            take = price[i] + f(i, n - rodLength, price, dp);

        return dp[i][n] = Math.max(take, notTake);
    }

    public int cutRod(int price[], int n) {
        int prev[] = new int[n + 1];
        // int curr[] = new int[n+1];
        for (int ni = 0; ni <= n; ni++) {
            prev[ni] = (ni / 1) * price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int N = 0; N <= n; N++) {
                int notTake = prev[N];
                int take = (int) -1e9;
                int rodLength = i + 1;
                if (rodLength <= N)
                    take = price[i] + prev[N - rodLength];

                prev[N] = Math.max(take, notTake);
            }
            // prev = curr;
        }

        return prev[n];

    }
}