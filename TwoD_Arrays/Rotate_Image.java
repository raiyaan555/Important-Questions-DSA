package TwoD_Arrays;

public class Rotate_Image {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        

        for (int i = 0; i <n; i++) {
            for (int j = i; j <m; j++) {
               int temp = matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=temp;
            }
        }
        
       
        for (int i = 0; i <n; i++) {
            int l =0;
            int r =m-1;

            while(l<r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r]= temp;

                l++;
                r--;
            }
            
        }
    }


    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = k++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println("Answer is ");
        rotate(arr);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
