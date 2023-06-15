package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Distance_nearest_0 {
    class Triplets{
        int first;
        int second;
        int third;

        Triplets(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        Queue<Triplets> q = new LinkedList<>();

        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Triplets(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;

            q.remove();

            dis[row][col] = steps;

            for(int i = 0; i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol] = 1;
                    q.add(new Triplets(nrow,ncol,steps+1));
                }
            }
        }
        return dis; 
    }
    
}
