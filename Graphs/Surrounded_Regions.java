package Graphs;

public class Surrounded_Regions {

    static void dfs(int row, int col, int vis[][], char mat[][], int[] delrow, int delcol[]) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;


        for(int i = 0; i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]=='O' && vis[nrow][ncol]==0){
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }

    static char[][] fill(int n, int m, char mat[][]) {
        int delrow[] = { -1, 0, 1, 0 };
        int delcol[] = { 0, 1, 0, -1 };

        int vis[][] = new int[n][m];

        for (int j = 0; j < m; j++) {

            // first row

            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol);
            }

            // last row

            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delrow, delcol);
            }

        }
        

        for (int i = 0; i < n; i++) {

            // first column

            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol);
            }

            // last column

            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delrow, delcol);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }

        }
        return mat;

    }
    public static void main(String[] args)
    {
        char mat[][] = {
        {'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4
        Surrounded_Regions ob = new Surrounded_Regions();
        char[][] ans = ob.fill(5, 4, mat);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
