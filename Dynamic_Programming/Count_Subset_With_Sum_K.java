package Dynamic_Programming;

import java.util.*;

public class Count_Subset_With_Sum_K {

    class TUF {

        static int findWays(int[] num, int k) {
            int n = num.length;

            int prev[] = new int[k + 1];

            prev[0] = 1;

            if (num[0] <= k)
                prev[num[0]] = 1;

            for (int ind = 1; ind < n; ind++) {
                int cur[] = new int[k + 1];
                cur[0] = 1;
                for (int target = 1; target <= k; target++) {

                    int notTaken = prev[target];

                    int taken = 0;
                    if (num[ind] <= target)
                        taken = prev[target - num[ind]];

                    cur[target] = notTaken + taken;
                }

                prev = cur;
            }

            return prev[k];

        }

        public static void main(String args[]) {

            int arr[] = { 1, 2, 2, 3 };
            int k = 3;

            System.out.println("The number of subsets found are " + findWays(arr, k));
        }
    }
}
