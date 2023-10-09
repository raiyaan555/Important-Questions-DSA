package Arrays;


public class P54_Position_of_Element_in_Sorted_Array {
    class Solution {
        public int[] searchRange(int[] arr, int target) {
            int lo = 0;
            int hi = arr.length-1;
            int c = 0;
    
            
            while(lo<=hi){
                int mid = lo+(hi-lo)/2;
                if(arr[mid]>target){
                    hi = mid-1;
                }
                else if(arr[mid]<target){
                    lo = mid+1;
                }else{
                    c=mid;
                    while(mid>=0 && arr[mid]==target){
                        mid--;
                    }
                    while(c<=hi && arr[c]==target){
                        c++;
                    }
                     return new int[]{++mid,--c};
                }
            }
            return new int[]{-1,-1};
        }
    }
}
