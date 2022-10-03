package Arrays;
import java.util.HashMap;

public class P15_Pair_with_a_given_sum_in_the_rotated_sorted_Array {

    public static int[] pairReturn(int[] arr, int target){
        int[] ans = new int[2];
        
        HashMap<Integer,  Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i, target-i);

            if(map.containsKey(target-i)){
                ans[0] = target-i;
                ans[1] = i;
            }
        }
        System.out.println(map);
        System.out.println(ans[0] +" "+ans[1]);
        return ans;
        
    }
    public static void main(String[] args) {
        int[] nums = {11, 15, 26, 38, 9, 10};
        System.out.println(pairReturn(nums, 35));
    }
}
