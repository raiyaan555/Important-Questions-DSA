public class P19_kth_smallest_element {
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len-1, k-1);
    }
    
    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        if(lo==hi)
            return arr[lo];
        int pivot = arr[hi];
        int pidx = partition(arr,pivot,lo,hi);
        if(pidx==k)
          return pivot;
        else if(k>pidx)
          return quickSelect(arr,pidx+1,hi,k);
        else
          return quickSelect(arr,lo,pidx-1,k);
    }
    
    private static int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            }
            else 
                i++;
        }
        return (j - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 1 ,3};
        System.out.println(findKthLargest(nums,3));
    }
}
