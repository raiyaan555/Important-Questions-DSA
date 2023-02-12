package Greedy;

public class Lexicographically_smallest_array_after_atmost_K_consecutive_swaps {
    static void minimizeWithKSwaps(int arr[], int n, int k) {
        for (int i = 0; i < n - 1 && k > 0; ++i) {

            int pos = i;
            for (int j = i + 1; j < n; ++j) {

                if (j - i > k)
                    break;

                if (arr[j] < arr[pos])
                    pos = j;
            }

            int temp;

            for (int j = pos; j > i; --j) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }

            k -= pos - i;
        }
    }

    // Driver method
    public static void main(String[] args) {

        int arr[] = { 7, 6, 9, 2, 1 };
        int n = arr.length;
        int k = 3;

        minimizeWithKSwaps(arr, n, k);

        // Print the final Array
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}
