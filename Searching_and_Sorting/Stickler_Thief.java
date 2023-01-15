package Searching_and_Sorting;

public class Stickler_Thief {
    public static int FindMaxSum(int arr[], int n) {
        // Your code here

        int i = 0;
        int j = n - 1;
        int max = Integer.MIN_VALUE;

        while (i < j) {
            if ((arr[i] + arr[j]) > max && j - i != 1) {
                max = arr[i] + arr[j];
                i++;
            } else {
                i = 0;
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 3;
        int a[] = { 1, 2, 3 };
        System.out.println(FindMaxSum(a, n));
    }
}
