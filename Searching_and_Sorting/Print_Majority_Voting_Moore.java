package Searching_and_Sorting;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Print_Majority_Voting_Moore {

    public static int majorityElement(int[] nums) {
        int count = 0; 
        int el =0;


        for(int i =0; i<nums.length; i++){
            if(count ==0){
                el = nums[i];
                count = 1;
            }

            else if(nums[i]==el){
                count++;
            }
            else if(nums[i]!=el){
                count--;
            }
        }

        int ans=0;

        for(int i = 0; i<nums.length;i++){
            if(nums[i]==el){
                ans++; 
            }
        }

        if(ans>nums.length/2){
            return el;
        }

        return -1;

    }

    

    public static void main(String[] args) {
        int N = 5;
        int A[] = { 3, 1, 3, 3, 2 };
        System.out.println(majorityElement(A));
    }

}
