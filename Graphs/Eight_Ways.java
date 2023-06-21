package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Eight_Ways {
    public int numIslands(char[][] grid) {
          int n = grid.length; 
          int m = grid[0].length; 
          int[][] vis = new int[n][m];
          int cnt = 0; 
          for(int row = 0; row < n ; row++) {
              for(int col = 0; col < m ;col++) {
                  // if not visited and is a land
                  if(vis[row][col] == 0 && grid[row][col] == '1') {
                      cnt++; 
                      bfs(row, col, vis, grid); 
                  }
              }
          }
          return cnt; 
      }

      private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1; 
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co)); 
        int n = grid.length; 
        int m = grid[0].length; 
        
       
        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            int[] delrow = {0,-1,-1,-1,0,1,1,1};
            int[] delcol = {-1,-1,0,1,1,1,0,-1};
           
            for(int i = 0;i<8;i++){
                int nrow = row + delrow[i]; 
                int ncol = col + delcol[i]; 
            
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1; 
                        q.add(new Pair(nrow, ncol)); 
                    }
            }
                    
                
            
        }
    }
      
      public static void main(String[] args)
      {
          char[][] grid =  {
              {'1', '1', '0', '0', '0'},
              {'0', '1', '0', '0', '1'},
               {'1', '0', '0', '1', '1'},
              {'0', '0', '0', '0', '0'},
               {'1', '0', '1', '0', '1'},
              

          };
                  
          No_of_islands obj = new No_of_islands();
          System.out.println(obj.numIslands(grid)-1);
      }
  
  }

  class Pair {
      int first;
      int second; 
      public Pair(int first, int second) {
          this.first = first; 
          this.second = second; 
      }
  }


