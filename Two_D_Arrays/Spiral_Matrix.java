package Two_D_Arrays;

import java.util.*;

public class Spiral_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top =0, down = n-1, left = 0, right = m-1;
        int dir = 0;
        int i;
        List<Integer> arr = new ArrayList<>();

        while(top<=down && left<=right){
           if(dir==0)
        {
            for(i=left;i<=right;i++)
                arr.add(matrix[top][i]);
            top++;
        }

        else if(dir==1)
        {
            for(i=top;i<=down;i++)
                arr.add(matrix[i][right]);
            right--;
        }

        else if(dir==2)
        {
            for(i=right;i>=left;i--)
                arr.add(matrix[down][i]);
            down--;
        }

        else if(dir==3){
            for(i=down;i>=top;i--)
                arr.add(matrix[i][left]);
            left++;
        }
         dir = (dir+1)%4;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=k++;
            }
        }

        System.out.print(spiralOrder(arr));
    }
}
