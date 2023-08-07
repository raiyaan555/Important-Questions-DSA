package Two_D_Arrays;

public class Search_in_2d_array {

    // this code works for the leetcode question but not for the gfg question 

    

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int lo = 0;
        int hi = n*m-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(matrix[mid/m][mid%m]==target){
                return true;
            }else if(matrix[mid/m][mid%m]>target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return false;
    }

    // this is the answer for the gfg code which gives the particular result;


    static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    int i = 0; int j = m-1;
	    
	    while(i<n && j>=0){
	        if(x==matrix[i][j]){
	            return true;
	        }else if(x>matrix[i][j]){
	            i++;
	        }else{
	            j--;
	        }
	    }
	    return false;
	} 
}
