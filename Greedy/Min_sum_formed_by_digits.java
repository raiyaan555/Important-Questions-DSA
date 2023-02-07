package Greedy;

import java.util.Arrays;

public class Min_sum_formed_by_digits {
    public static long minSum(int arr[], int n)
    {
        long m1=0, m2=0;
        Arrays.sort(arr);
        // Your code goes here
        for(int i =0; i<n;i++){
            if(i%2==0){
                m1 = m1*10+arr[i];
            }else{
                m2=m2*10+arr[i];
            }
        }
        return m1+m2;
    }
}
