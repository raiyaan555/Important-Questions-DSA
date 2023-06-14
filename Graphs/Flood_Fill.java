package Graphs;

public class Flood_Fill {

    // the time complexity is 4*N*M and space is O(n*M too with auxiallry stack space)

    // important algo



    private void dfs(int row, int col, int [][] ans, int [][]image, int newColor, int delRow[], int delCol[], int iniColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i<4; i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && ans[nrow][ncol]!=newColor){
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }


    public int[][] floddFill(int[][] image, int sr, int sc, int newColor){

        int initColor = image[sr][sc];
        int[][] ans = image;
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        dfs(sr,sc,ans,image,newColor,delRow, delCol,initColor);

        return ans;



    }

    public static void main(String[] args)
    {
        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };

        // sr = 1, sc = 1, newColor = 2       
        Flood_Fill obj = new Flood_Fill();
        int[][] ans = obj.floddFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
