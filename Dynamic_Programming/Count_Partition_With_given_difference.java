package Dynamic_Programming;

import java.util.*;

class TUF {
    static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {

        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = notTaken + taken;
    }

    static int findWays(int[] num, int k) {
        int n = num.length;
        int dp[][] = new int[n][k + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return findWaysUtil(n - 1, k, num, dp);
    }

    public static void main(String args[]) {

        int arr[] = { 0, 0, 1 };
        int k = 1;

        System.out.println("The number of subsets found are " + findWays(arr, k));
    }
}

public class Count_Partition_With_given_difference {

    class TUF {
        static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {

            if (ind == 0) {
                if (target == 0 && arr[0] == 0)
                    return 2;
                if (target == 0 || target == arr[0])
                    return 1;
                return 0;
            }

            if (dp[ind][target] != -1)
                return dp[ind][target];

            int notTaken = findWaysUtil(ind - 1, target, arr, dp);

            int taken = 0;
            if (arr[ind] <= target)
                taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

            return dp[ind][target] = notTaken + taken;
        }

        static int findWays(int[] num, int k) {
            int n = num.length;
            int dp[][] = new int[n][k + 1];

            for (int row[] : dp)
                Arrays.fill(row, -1);

            return findWaysUtil(n - 1, k, num, dp);
        }

        public static void main(String args[]) {

            int arr[] = { 0, 0, 1 };
            int k = 1;

            System.out.println("The number of subsets found are " + findWays(arr, k));
        }
    }
}
