package Arrays;

public class P21_Sort_Colors {

    // optimal sol O(N) with O(3) space complexity



    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1, temp;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0: {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;
                    high--;
                    break;
                }
            }
        }
    }



    // brute force approach is use bubble sort or merge sort and do it.

    public void sortColors2(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
