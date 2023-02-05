package Two_D_Arrays;

public class Surrounded_Regions {
    public static void replaceOs(char mat[][], int x, int y, char prevV, char newV) {
        if (x < 0 || x >= mat.length ||
                y < 0 || y >= mat[0].length)
            return;

        if (mat[x][y] != prevV)
            return;

        mat[x][y] = newV;

        replaceOs(mat, x + 1, y,
                prevV, newV);
        replaceOs(mat, x - 1, y,
                prevV, newV);
        replaceOs(mat, x, y + 1,
                prevV, newV);
        replaceOs(mat, x, y - 1,
                prevV, newV);
    }

    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == 'O')
                    board[i][j] = '*';

        for (int i = 0; i < board.length; i++)
            if (board[i][0] == '*')
                replaceOs(board, i, 0, '*', 'O');

        for (int i = 0; i < board.length; i++)
            if (board[i][board[0].length - 1] == '*')
                replaceOs(board, i, board[0].length - 1, '*', 'O');

        for (int i = 0; i < board[0].length; i++)
            if (board[0][i] == '*')
                replaceOs(board, 0, i, '*', 'O');

        for (int i = 0; i < board[0].length; i++)
            if (board[board.length - 1][i] == '*')
                replaceOs(board, board.length - 1, i, '*', 'O');

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == '*')
                    board[i][j] = 'X';
    }

    public static void main(String[] args) {
        char[][] ch = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
        };

        solve(ch);

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[0].length; j++) {
                System.out.print(ch[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
