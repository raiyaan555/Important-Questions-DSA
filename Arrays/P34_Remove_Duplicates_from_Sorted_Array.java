package Arrays;

public class P34_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums)
    {
        int c = 0;
        
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == nums[i - 1])
                c++;
            
            nums[i - c] = nums[i];
        }
        
        return nums.length - c;
    }
}
