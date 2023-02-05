package Two_D_Arrays;

public class Create_matrix_with_alternating_rectangles_of_O_and_X {

    static void fill0X(int m, int n) {

        int i, top = 0, left = 0, down = m, right = n;

        char a[][] = new char[m][n];
        char x = 'X';
        while (top < down && left < right) {

            for (i = left; i < right; ++i)
                a[top][i] = x;
            top++;

            for (i = top; i < down; ++i)
                a[i][right - 1] = x;
            right--;

            if (top < down) {
                for (i = right - 1; i >= left; --i)
                    a[down - 1][i] = x;
                down--;
            }

            if (left < right) {
                for (i = down - 1; i >= top; --i)
                    a[i][left] = x;
                left++;
            }

            x = (x == '0') ? 'X' : '0';
        }

        for (i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Output for m = 4, n = 3");
        fill0X(4, 3);
    }
}
