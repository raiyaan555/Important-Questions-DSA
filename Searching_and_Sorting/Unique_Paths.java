package Searching_and_Sorting;

public class Unique_Paths {

    // brute force time complexity is exponential and space also exponential

    public int  paths(int i,int j,int m,int n){
        if(i>=n ||j>=m) return 0;
        if(i==n-1 && j==m-1) return 1;
         return (paths(i+1, j,m,n) + paths(i,j+1,m,n));
    }
    public int uniquePaths(int m, int n) {
        return paths(0,0,m,n);
    }
}
