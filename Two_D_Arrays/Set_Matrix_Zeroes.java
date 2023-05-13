package Two_D_Arrays;

import java.util.HashSet;
import java.util.Set;

public class Set_Matrix_Zeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean row = false, column = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                column = true;
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                row = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (column) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = k++;
            }
        }
        setZeroes(arr);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

/*
 * optimal solution
 * 
 * time complexity of the down below code is 2*(n*m) almost exact will be n*m +
 * n-1*m-1
 * 
 * space complexity will be 0(1);
 * 
 */
class Solution {
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    // brute force solution

    class Solution2 {
        public void setZeroes(int[][] matrix) {
            int R = matrix.length;
            int C = matrix[0].length;
            Set<Integer> rows = new HashSet<Integer>();
            Set<Integer> cols = new HashSet<Integer>();

            // Essentially, we mark the rows and columns that are to be made zero
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (matrix[i][j] == 0) {
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }

            // Iterate over the array once again and using the rows and cols sets, update
            // the elements.
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (rows.contains(i) || cols.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
