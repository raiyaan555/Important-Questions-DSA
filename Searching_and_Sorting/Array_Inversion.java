package Searching_and_Sorting;

import java.util.ArrayList;
import java.util.HashSet;

public class Array_Inversion {
    static long count = 0;

    public static long[] mergeSort(long[] arr, int lo, int hi){

        if(lo==hi){
            long[] ba = new long[1];
            ba[0] = arr[lo];
            return ba;
        }

        int mid = (lo+hi)/2;

        long[] left = mergeSort(arr, 0, mid);
        long[] right = mergeSort(arr,mid+1, hi);
        
        long[] merged = merge2SortedArrays(left,right);

        return merged;

    }

    public static long[] merge2SortedArrays(long[] left, long[] right){
        int i = 0; 
        int j = 0;
        int k = 0;

        long[]merged = new long[left.length+right.length];

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                merged[k++] = left[i++];
            }else{
                count+= left.length-i;
                merged[k++] = right[j++];
            }
        }

        while(i<left.length){
            merged[k++] = left[i++];
        }
        while(j<right.length){
            merged[k++] = right[j++];
        }
        return merged;

    }

    

    public static long merge(long arr[], int low, int mid, int high){
        int left = low;
        int right = high;
        long invCount = 0;
        ArrayList<Long> temp = new ArrayList<>();

        while(left<=mid-1 && left<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
                invCount = invCount +(mid-left);
            }
        }

        while(left<=mid)
        {
            temp.add(arr[left++]);
        }

         while(right<=high)
        {
            temp.add(arr[right++]);
        }
        

        for(int i =low; i<high;i++){
            arr[i] = temp.get(i-low);
        }

        return invCount;
    }

    public static long mergedSort(long arr[], int low, int high){
        int mid;
        long invCount =0;
        if(high>low) {
            mid = (low+high)/2;
            invCount += mergedSort(arr,low,mid);
            invCount += mergedSort(arr,mid+1,high);
            invCount += merge(arr,low,mid,high);
        }
        return invCount;
    }

    public static long getInversions(long arr[], int n) {
        // Write your code here.

        return mergedSort(arr,0,n-1);
    }
}


    // public static boolean isNotSame(long[] arr){
    //     HashSet<Long> set = new HashSet<>();

    //     for(int i = 0; i<arr.length; i++){
    //         set.add(arr[i]);
    //     }
    //     if(set.size() !=1){
    //         return true;
    //     }
    //     return false;
    // }

    // public static boolean isNotSorted(long[] arr){
    //     int flag = 0;
    //     for(int i = 0; i<arr.length-1; i++){
    //         if(arr[i]>arr[i+1]){
    //             flag = 1;
    //             break;
    //         }
    //     }
    //     if(flag !=0){
    //         return true;
    //     }
    //     return false;
    // }

    
    static long inversionCount(long arr[], long N)
    {

        mergeSort(arr, 0, (int)N);

        return count;






        // long count = 0;
        // if(isNotSame(arr) && isNotSorted(arr)){

        //     for(int i = 0; i<N;i++){
        //         for(int j = i+1; j<N;j++){
        //             if(arr[i]>arr[j]){
        //                 count++;
        //             }
        //         }
        //     }

        // }
        // return count;


        // Enhanced merge sort technique 




    }
    public static void main(String[] args) {
        long []arr = {2,1,5,6,2,5,3,4,6,3,8,9,6,0,6,5};

        System.out.println(inversionCount(arr, arr.length));
    }
}
