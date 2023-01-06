package Searching_and_Sorting;

import java.util.*;

public class Searching_in_array_where_adjacent_differ_by_at_most_k {
    public static int search(int arr[], int n, int x, int k) {
       for(int i =0; i<n; i++){
        if(arr[i]==x)
        return i;
       }

       return -1;
    }

    public static void main(String[] args) {
        int arr[ ] = {4, 5, 6, 7, 6}; int K = 1 ;
        int  X = 6;

       System.out.println(search(arr, arr.length, X, K)) ;
    }
}
