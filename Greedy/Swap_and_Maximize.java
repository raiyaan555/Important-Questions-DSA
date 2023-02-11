package Greedy;

import java.util.Arrays;

public class Swap_and_Maximize {
    long maxSum(long ans[], int n) {

        Arrays.sort(ans);

        long s = 0;

        int l = 0;
        int r = n - 1;

        while (l < r) {
            s += Math.abs(ans[l] - ans[r]);
            s += Math.abs(ans[l + 1] - ans[r]);
            l++;
            r--;
        }

        s += Math.abs(ans[0] - ans[l]);
        return s;

    }
}
