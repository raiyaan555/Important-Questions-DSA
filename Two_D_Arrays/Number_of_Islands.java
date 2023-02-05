package Two_D_Arrays;

public class Number_of_Islands {
    public static int numIslands(char[][] grid) {
        int c = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    islandSearch(grid, i, j, visited);
                    c++;
                }
            }
        }
        return c;
    }

    private static void islandSearch(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == true)
            return;

        visited[i][j] = true;

        islandSearch(grid, i - 1, j, visited);
        islandSearch(grid, i, j + 1, visited);
        islandSearch(grid, i, j - 1, visited);
        islandSearch(grid, i + 1, j, visited);

    }

    public static void main(String[] args) {
        char[][] ch = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        System.out.println(numIslands(ch));
    }
}
