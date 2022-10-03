package Arrays;
import java.util.HashMap;

public class P23_SubArraySum_Divisible_by_k_leetcode {
    public static int subarraysDivByK(int[] nums, int k) {
        int total = 0, sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            if (rem < 0) rem += k;

            if (map.containsKey(rem)) {
                total += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }

            map.putIfAbsent(rem, 1);
        }

        return total;
    }


    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, 2, 3, 1 };
        System.out.println(subarraysDivByK(nums, 5));
    }
}
