package Stack_and_Queues;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row = 0;
    int col = 0;
    int tm = 0;

    Pair(int _row, int _col, int _tm) {
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }

}

public class Rotten_Oranges {
    public int orangesRotting(int[][] grid)

    {

        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair>q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) fresh++;
            }
        }

        int cnt = 0;
        int tm = 0;
        int row_move[] = {-1, 0, +1, 0};
        int col_move[] = {0, +1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t);
            q.remove();
            for(int i=0; i<4; i++){
                int nrow = r+row_move[i]; int ncol = c+col_move[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){

                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;

                }
            }           
        }
        if(cnt != fresh) return -1;    
        return tm;
    }
}
