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
}
