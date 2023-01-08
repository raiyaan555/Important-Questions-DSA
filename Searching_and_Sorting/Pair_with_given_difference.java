package Searching_and_Sorting;

import java.util.*;

public class Pair_with_given_difference {
    public static boolean findPair(int arr[], int size, int n) {

        int i = 0, j, k;
        Arrays.sort(arr);

        for (i = 0; i < size; i++) {
            j = i;
            k = size - 1;
            while (j < k) {
                int diff = arr[k] - arr[j];
                if (diff == n) {
                    return true;
                } else if (diff < n) {
                    j++;
                } else if (diff > n) {
                    k--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 20, 3, 2, 5, 80 };
        int L = 6;
        int N = 78;
        System.out.println(findPair(arr, L, N));

    }

}
