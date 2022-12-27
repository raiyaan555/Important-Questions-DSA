package Searching_and_Sorting;

import java.util.*;

public class Permutations_in_array {

    public static void reverse(long[] array) {

        int n = array.length;
        for (int i = 0; i < n / 2; i++) {

            long temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    public static boolean isPossible(Integer a[], long b[], int n, long k) {
        if (a.length != b.length) {
            return false;
        }

        Arrays.sort(a, Collections.reverseOrder());

        Arrays.sort(b);

        for (int i = 0; i < n; i++)
            if (a[i] + b[i] < k)
                return false;

        return true;

    }

    public static void main(String[] args) {
        Integer a[] = {2, 1, 3};
        long b[] = {7, 8, 9};
        int k = 10;
        int n = a.length;
     
        if (isPossible(a, b, n, k))
        System.out.print("Yes");
        else
        System.out.print("No");
    }
}
