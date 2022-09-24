import java.util.*;

public class P3_Max_Sub_Array {
    public static int maxSubArray(int[] nums) {

        int currSum = 0;
        int maxSub = nums[0];

        for (int i : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum +=i;
            if(maxSub<currSum){
                maxSub=currSum;
            }
        }
        return maxSub;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the desired characters in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubArray(arr));
    }
}
