package Arrays;

public class P36_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 0;
            }

            if (count <= 1) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
