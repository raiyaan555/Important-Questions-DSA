package Arrays;
public class P21_Find_minimum_number_of_merge_operations_to_make_an_array_palindrome {
    public static int FindMin(int arr[]) {

        int ans[] = new int[arr.length];
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = arr[i];
            if (ans[i] - arr[arr.length - 1 - i] != 0) {
                count++;
            }
        }
        if (count == 0) {
            return 0;

        } else if(arr.length%2==0){
            return count-1;
        } else if(arr.length%2!=0){
            return count;
        }

        return count;

        

    }

    public static void main(String[] args) {
        int[] nums = { 11,2,3,4,3,2,11};
        System.out.println(FindMin(nums));
    }
}
