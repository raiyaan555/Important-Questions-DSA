import java.util.*;

public class P20_Merge_Overlapping {

    public static int[][] merge(int[][] intervals) {
        // sorting the array on basis of first element
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // creating a list for storing merged intervals
        ArrayList<int[]> res = new ArrayList<>();
        // creating a temporary array for comparisons and initialising it with first
        // element of intervals
        int[] temp = intervals[0];
        // loop starts from index 1 because index-0 is already stored in the temp array
        // and that could be the merge interval
        for (int i = 1; i < intervals.length; i++) {
            // if the last index of temp > first index of interval[i] then update the last
            // index of temp array
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(intervals[i][1], temp[1]);
            }
            // if last index of temp < first index of interval[i] then add the temp array
            // and reinitialise it with current intervals[i]
            else {
                res.add(temp);
                temp = intervals[i];
            }
        }
        // adding the temp array outside of the loop because we are storing the next
        // possible merge intervals in the temp array always (so,when loop will break a
        // merge interval will be stored in the temp array)
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(nums));
    }
}
