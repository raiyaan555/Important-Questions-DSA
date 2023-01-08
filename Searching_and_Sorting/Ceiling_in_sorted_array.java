package Searching_and_Sorting;

public class Ceiling_in_sorted_array {


    public static int ceilSearch(int[] arr, int x){
        int low =0, high=arr.length-1; int mid;

        if(high==0){
            return -1;
        }

        while(low<=high){
            mid = low+(high-low)/2;
            if (x == arr[mid]) {
                return mid;
            }
            else if (x < arr[mid]) {
                high = mid - 1;
            }
            else if(x > arr[mid]) {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
        int x = 11;

        System.out.println(arr[ceilSearch(arr, x)]);
    }
}
