package Strings;

import java.util.ArrayList;
import java.util.List;

public class P13_Next_Permutation {

    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void reverse(int[] arr, int a, int b){
        while(a<b){
            swap(arr, a++, b--);
        }
    }

    static List<Integer> nextPermutation(int N, int arr[]) {
        List<Integer> ans = new ArrayList<>();

        if(arr == null || arr.length <=1){
            return ans;
        }
         int i = N-2;

        while(i>=0  && arr[i]>=arr[i+1]){
            i--;
            
        }

        if(i>=0){
            int j = arr.length -1;
            while(arr[j]<=arr[i])j--;
            swap(arr,i,j);
        }
        reverse(arr,i+1, N-1);

        for(int k=0; k<arr.length;k++){
            System.out.print(arr[k]+", ");
        }
        System.out.println();

        for(int k=0; k<arr.length;k++){
           ans.add(arr[k]);
        }
       

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 5, 4 };
        System.out.println(nextPermutation(arr.length, arr));
    }
}
