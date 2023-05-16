package Arrays;
public class P8_best_time_to_buy_stocks {


    // optimal solution with time complexity equal to O(n) and space complexity O(3)

    public static int maxProfit(int[] arr) {

        int a = Integer.MAX_VALUE;
        int b = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < a) {
                a = arr[j];
            }
            b = arr[j] - a;

            if (ans < b) {
                ans = b;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 1};
        System.out.println(maxProfit(nums));
    }

}
