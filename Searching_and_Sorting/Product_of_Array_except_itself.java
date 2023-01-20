package Searching_and_Sorting;

public class Product_of_Array_except_itself {
    public static int[] productExceptSelf(int nums[], int n) {
        int result = 1;

        int prod[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            prod[i] = result;
            result *= nums[i];
        }

        result = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            prod[i] *= result;
            result *= nums[i];
        }

        return prod;

    }

    public static void main(String[] args) {
        int n = 5;
        int nums[] = { 10, 3, 5, 6, 2 };

        System.out.println((productExceptSelf(nums, n)[0]) + " " + productExceptSelf(nums, n)[1] + " "
                + productExceptSelf(nums, n)[2] + " " + productExceptSelf(nums, n)[3] + " "
                + productExceptSelf(nums, n)[4] + " ");
    }
}
