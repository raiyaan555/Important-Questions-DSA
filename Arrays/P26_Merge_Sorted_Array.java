package Arrays;

// time is O(n+m)  and space is O(3);

public class P26_Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m-1;
        int b = n-1;
        int k = m+n-1;
 
        while(a>=0 && b>=0){
            if(nums1[a]<nums2[b]){
                nums1[k--] = nums2[b--];
            }else{
                nums1[k--] = nums1[a--];
            }
        }
 
     while(b>=0){
         nums1[b] = nums2[b--];
     }   
    }
}
