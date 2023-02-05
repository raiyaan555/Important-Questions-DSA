package Two_D_Arrays;

import java.util.ArrayList;

public class Word_Search {

    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }
    
    private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
            || exist(board, y, x-1, word, i+1)
            || exist(board, y+1, x, word, i+1)
            || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
    public static void main(String[] args) {
        char[][] arr = new char[3][3];
        char k=97;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=k++;
            }
        }

        System.out.println(exist(arr, "abcfihge"));
    }
}
