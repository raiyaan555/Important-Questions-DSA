package Recursion;

import java.util.* ;
import java.io.*; 
public class Subset_Sums {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..

        ArrayList<Integer> ans = new ArrayList<>();
        f(0,0,num,ans);
        Collections.sort(ans);
        return ans;
    }

    public static void f(int i,int sum,int arr[], ArrayList<Integer> ans){
        if(i==arr.length){
            ans.add(sum);
            return;
        }
        f(i+1,sum+arr[i],arr,ans);
        f(i+1,sum,arr,ans);
    }

}

