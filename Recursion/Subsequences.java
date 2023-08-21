package Recursion;

import java.util.ArrayList;

public class Subsequences {
    // we have two options whether to take it or not take it
    public static void f(int index, ArrayList<Integer> path,int n, int[] arr){
        if (index == arr.length)
    {
         
        // if (path.size() > 0)
            System.out.println(path);
            return;
    }
     
    else
    {
         
        // Subsequence without including
        // the element at current index
        f( index + 1, path,n,arr);
         
        path.add(arr[index]);
         
        // Subsequence including the element
        // at current index
        f( index + 1, path,n,arr);
         
        // Backtrack to remove the recently
        // inserted element
        path.remove(path.size() - 1);
    }

    }
    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();
        int[] arr = {1,2,3,4,5};
        f(0,temp,arr.length,arr);
    }
}
