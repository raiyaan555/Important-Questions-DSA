package TwoD_Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Print_Diagonals {
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        int row = 0;
        int column = 0;
        
        while(column<N){
            int r=row;
            int c=column;
            while(r<N && c>=0){
                arr.add(A[r][c]);
                r++;
                c--;
                
        }
        column++;
        }
        
        column=N-1;
        row=1;
        while(row<N){
            int r=row;
            int c=column;
            while(r<N && c>=0){
                arr.add(A[r][c]);
                r++;
                c--;
                
        }
        row++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int k=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=k++;
            }
        }
        System.out.print(downwardDigonal(3,arr));
    }
}
