package Arrays;

public class P21_Find_Duplicate_Number_in_Nplus1_array {
    public int findDuplicate(int[] nums) {

        // using the hare tortois method space - O(2) and time -O(2n);

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);


        fast = nums[0];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
