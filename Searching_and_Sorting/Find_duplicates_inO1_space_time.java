package Searching_and_Sorting;
import java.util.*;


//  only valid for numbers that are actually less than the length of the array


public class Find_duplicates_inO1_space_time {

    public static ArrayList<Integer> findDuplicate(int[]arr){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            arr[arr[i]%arr.length]+=arr.length;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length * 2) {
                ans.add(i);
            }
        }
        return ans;

        
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,6,3,6,1};

        System.out.println(findDuplicate(arr));

       
    }
    
}
