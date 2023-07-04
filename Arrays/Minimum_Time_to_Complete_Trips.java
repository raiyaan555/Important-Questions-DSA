package Arrays;

public class Minimum_Time_to_Complete_Trips {

    public long minimumTime(int[] time, int totalTrips) {
        long lo = 0;
        long hi = (long) 1e14;
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = 0;
            for (int i : time) {
                cnt += mid / i;
            }
            if (cnt >= totalTrips) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
