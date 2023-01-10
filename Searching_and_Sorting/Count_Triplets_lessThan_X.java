package Searching_and_Sorting;
import java.util.*;

public class Count_Triplets_lessThan_X {
    static long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
        long ans = 0;
        for(int i = 0; i<n-2;i++){
            int j = i + 1, k = n - 1;

            while(j<k){
                
                if(arr[i]+arr[j]+arr[k]>=sum){
                    k--;
                }
                else{
                    ans+= (k-j);
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 4,sum = 2;  long arr[] = {-2, 0, 1, 3} ;
        System.out.println(countTriplets(arr, N, sum));
    }
}
