package Arrays;
public class P14_Find_Minimum_in_Rotated_Sorted_Array {

    public static int findMin(int[] arr) {
        // int deflectionPoint = 0;
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < arr[right]) {
                right = mid;
            } else if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
        }
        return arr[right];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(findMin(nums));
    }
}
