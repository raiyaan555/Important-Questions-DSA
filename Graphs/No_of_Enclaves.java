package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// Space complexity is O(N*M) and time complexity is O (4*N*M)
class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class No_of_Enclaves {
    int numberOfEnclaves(int [][] grid){
        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;


        int vis[][] = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                if(i==0 || j==0 || i==n-1|| j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            for(int i =0; i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }

        int c = 0; 

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    c++;
                }
            }
        }

        return c;


    }
}
