package Competitive_Coding;

import java.util.*;

public class Rudolph_Tic_Tac_Toe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int k = 0; k < n; k++) {
            char[][] grid = new char[3][3];

            for (int i = 0; i < 3; i++) {
                String row = sc.next();
                for (int j = 0; j < 3; j++) {
                    grid[i][j] = row.charAt(j);
                }
            }

            String result = findWin(grid);
            System.out.println(result);
        }
    }

    static String findWin(char[][] grid) {

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != '.' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return String.valueOf(grid[i][0]);
            }
        }

        for (int j = 0; j < 3; j++) {
            if (grid[0][j] != '.' && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
                return String.valueOf(grid[0][j]);
            }
        }
        if (grid[0][0] != '.' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return String.valueOf(grid[0][0]);
        }
        if (grid[0][2] != '.' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return String.valueOf(grid[0][2]);
        }
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '.') {
                    isFull = false;
                    break;
                }
            }
        }
        if (isFull) {
            return "DRAW";
        }
        return "DRAW";
    }
}
